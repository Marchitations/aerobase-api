package com.aerobase.backend.util;

import com.aerobase.backend.dto.AeronaveHistoricoDTO;
import com.aerobase.backend.model.AeronaveHistorico;

public class AeronaveHistoricoMapper {

    private AeronaveHistoricoMapper() {
    }

    public static AeronaveHistoricoDTO toDTO(AeronaveHistorico entity) {
        AeronaveHistoricoDTO dto = new AeronaveHistoricoDTO();
        dto.setCampo(entity.getCampo());
        dto.setValorAnterior(entity.getValorAnterior());
        dto.setValorNovo(entity.getValorNovo());
        dto.setDataAlteracao(entity.getDataAlteracao());
        return dto;
    }
}
