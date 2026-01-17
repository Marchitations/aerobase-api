package com.aerobase.backend.util;

import com.aerobase.backend.dto.AeronaveCreateDTO;
import com.aerobase.backend.dto.AeronaveEditDTO;
import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.model.Aeronave;

import java.util.List;
import java.util.stream.Collectors;

public class    AeronaveMapper {

    public Aeronave toEntity(AeronaveCreateDTO dto){
        Aeronave aeronave = new Aeronave();
        aeronave.setNome(dto.getNome());
        aeronave.setMarca(dto.getMarca());
        aeronave.setAno(dto.getAno());
        aeronave.setDescricao(dto.getDescricao());
        aeronave.setVendido(dto.getVendido());
        return aeronave;
    }

    public void updateEntity(AeronaveEditDTO dto, Aeronave aeronave){
        aeronave.setNome(dto.getNome());
        aeronave.setMarca(dto.getMarca());
        aeronave.setAno(dto.getAno());
        aeronave.setDescricao(dto.getDescricao());
        aeronave.setVendido(dto.getVendido());
    }

    public static AeronaveResponseDTO toResponse(Aeronave aeronave){
        AeronaveResponseDTO dto = new AeronaveResponseDTO();
        dto.setId(aeronave.getId());
        dto.setNome(aeronave.getNome());
        dto.setMarca(aeronave.getMarca());
        dto.setAno(aeronave.getAno());
        dto.setDescricao(aeronave.getDescricao());
        dto.setVendido(aeronave.getVendido());
        dto.setCriado(aeronave.getCriado());
        dto.setAtualizado(aeronave.getAtualizado());
        return dto;
    }

    public static List<AeronaveResponseDTO> toResponse(List<Aeronave> aeronaves) {
        return aeronaves.stream()
                .map(AeronaveMapper::toResponse)
                .collect(Collectors.toList());
    }
}
