package com.aerobase.backend.service;

import com.aerobase.backend.dto.AeronaveCreateDTO;
import com.aerobase.backend.dto.AeronaveEditDTO;
import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.exception.AeronaveNotFoundException;
import com.aerobase.backend.model.Aeronave;
import com.aerobase.backend.repository.AeronaveRepository;
import com.aerobase.backend.util.AeronaveMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class AeronaveService {

    private final AeronaveRepository repository;

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
        return AeronaveMapper.toResponse(repository.save(aeronave));
    }

    public AeronaveResponseDTO update(Long id, AeronaveEditDTO dto){
        Aeronave aeronave = repository.findById(id).
                orElseThrow(AeronaveNotFoundException::new);

        AeronaveMapper.updateEntity(dto, aeronave);

        Aeronave updated = repository.save(aeronave);
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
        repository.deleteById(id);
    }
}
