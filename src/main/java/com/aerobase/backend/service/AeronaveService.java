package com.aerobase.backend.service;

import com.aerobase.backend.dto.AeronaveCreateDTO;
import com.aerobase.backend.dto.AeronaveEditDTO;
import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.exception.AeronaveNotFoundException;
import com.aerobase.backend.exception.BusinessException;
import com.aerobase.backend.model.Aeronave;
import com.aerobase.backend.repository.AeronaveRepository;
import com.aerobase.backend.util.AeronaveMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AeronaveService {

    private final AeronaveRepository repository;
    private final AeronaveHistoricoService aeronaveHistoricoService;

    public AeronaveResponseDTO findByID(Long id){
        return AeronaveMapper.toResponse(findAeronave(id));
    }

    private Aeronave findAeronave(Long id) {
        return repository.findById(id)
                .orElseThrow(AeronaveNotFoundException::new);
    }

    public List<AeronaveResponseDTO> findAll() {
        return AeronaveMapper.toResponse(
                repository.findAll(Sort.by(Sort.Direction.ASC, "criado"))
        );
    }

    public AeronaveResponseDTO create(AeronaveCreateDTO dto){
        Aeronave aeronave = AeronaveMapper.toEntity(dto);
        validarAno(aeronave.getAno());
        return AeronaveMapper.toResponse(repository.save(aeronave));
    }

    public AeronaveResponseDTO update(Long id, AeronaveEditDTO dto) {
        Aeronave aeronave = repository.findById(id)
                .orElseThrow(AeronaveNotFoundException::new);

        validarEdicao(aeronave);
        validarAno(dto.getAno());

        String nomeAntigo = aeronave.getNome();
        String marcaAntiga = aeronave.getMarca();
        Integer anoAntigo = aeronave.getAno();
        String descricaoAntiga = aeronave.getDescricao();

        AeronaveMapper.updateEntity(dto, aeronave);
        Aeronave updated = repository.save(aeronave);
        registrarHistorico(aeronave, dto, nomeAntigo, marcaAntiga, anoAntigo, descricaoAntiga);
        return AeronaveMapper.toResponse(updated);
    }

    public List<AeronaveResponseDTO> find(String term) {
        if (term == null || term.isBlank()) {
            throw new IllegalArgumentException("O termo de busca nao pode estar vazio");
        }

        return repository.findByTerm(term).stream()
                .map(AeronaveMapper::toResponse)
                .toList();
    }

    public void delete(Long id){
        Aeronave aeronave = repository.findById(id)
                .orElseThrow(AeronaveNotFoundException::new);
        repository.delete(aeronave);
    }

    private void validarAno(Integer ano) {
        int anoAtual = Year.now().getValue();

        if (ano != null && ano > anoAtual) {
            throw new BusinessException("Ano da aeronave não pode ser no futuro");
        }
    }

    private void validarEdicao(Aeronave aeronave) {
        if (Boolean.TRUE.equals(aeronave.getVendido())) {
            throw new BusinessException("Aeronave vendida não pode ser editada");
        }
    }

    private void registrarHistorico(
            Aeronave aeronave,
            AeronaveEditDTO dto,
            String nomeAntigo,
            String marcaAntiga,
            Integer anoAntigo,
            String descricaoAntiga
    ) {
        if (dto.getNome() != null && !dto.getNome().equals(nomeAntigo)) {
            aeronaveHistoricoService.registrarAlteracao(
                    aeronave, "nome", nomeAntigo, dto.getNome());
        }

        if (dto.getMarca() != null && !dto.getMarca().equals(marcaAntiga)) {
            aeronaveHistoricoService.registrarAlteracao(
                    aeronave, "marca", marcaAntiga, dto.getMarca());
        }

        if (dto.getAno() != null && !dto.getAno().equals(anoAntigo)) {
            aeronaveHistoricoService.registrarAlteracao(
                    aeronave, "ano", anoAntigo, dto.getAno());
        }

        if (dto.getDescricao() != null && !dto.getDescricao().equals(descricaoAntiga)) {
            aeronaveHistoricoService.registrarAlteracao(
                    aeronave, "descricao", descricaoAntiga, dto.getDescricao());
        }
    }
}
