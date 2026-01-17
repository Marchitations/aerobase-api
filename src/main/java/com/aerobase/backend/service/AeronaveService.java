package com.aerobase.backend.service;

import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.model.Aeronave;
import com.aerobase.backend.repository.AeronaveRepository;
import com.aerobase.backend.util.AeronaveMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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
        try {
            return repository.findById(id).get();
        } catch (Exception exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<AeronaveResponseDTO> findAll(){
        return AeronaveMapper.toResponse(repository.findAll());
    }
}
