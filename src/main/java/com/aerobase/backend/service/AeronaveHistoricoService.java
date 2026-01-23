package com.aerobase.backend.service;

import com.aerobase.backend.dto.AeronaveHistoricoDTO;
import com.aerobase.backend.exception.AeronaveNotFoundException;
import com.aerobase.backend.model.Aeronave;
import com.aerobase.backend.model.AeronaveHistorico;
import com.aerobase.backend.repository.AeronaveHistoricoRepository;
import com.aerobase.backend.repository.AeronaveRepository;
import com.aerobase.backend.util.AeronaveHistoricoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AeronaveHistoricoService {

    private final AeronaveHistoricoRepository historicoRepository;
    private final AeronaveRepository aeronaveRepository;

    public AeronaveHistoricoService(
            AeronaveHistoricoRepository historicoRepository,
            AeronaveRepository aeronaveRepository
    ) {
        this.historicoRepository = historicoRepository;
        this.aeronaveRepository = aeronaveRepository;
    }

    public void registrarAlteracao(
            Aeronave aeronave,
            String campo,
            Object valorAnterior,
            Object valorNovo
    ) {
        AeronaveHistorico historico = new AeronaveHistorico();
        historico.setAeronave(aeronave);
        historico.setCampo(campo);
        historico.setValorAnterior(valorAnterior != null ? valorAnterior.toString() : null);
        historico.setValorNovo(valorNovo != null ? valorNovo.toString() : null);

        historicoRepository.save(historico);
    }

    public List<AeronaveHistoricoDTO> buscarHistorico(Long aeronaveId) {
        aeronaveRepository.findById(aeronaveId)
                .orElseThrow(AeronaveNotFoundException::new);

        return historicoRepository.findByAeronaveIdOrderByDataAlteracaoDesc(aeronaveId)
                .stream()
                .map(AeronaveHistoricoMapper::toDTO)
                .toList();
    }
}