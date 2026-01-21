package com.aerobase.backend.controller;


import com.aerobase.backend.dto.AeronaveCreateDTO;
import com.aerobase.backend.dto.AeronaveEditDTO;
import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.service.AeronaveService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/aeronaves")
@AllArgsConstructor
public class AeronaveController{
    private AeronaveService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AeronaveResponseDTO> findAll(){
        return service.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AeronaveResponseDTO findById(@PathVariable Long id){
        return service.findByID(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public AeronaveResponseDTO update(@PathVariable Long id, @Valid @RequestBody AeronaveEditDTO aeronaveEditDTO){
        return service.update(id, aeronaveEditDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find")
    public List<AeronaveResponseDTO> find(
            @RequestParam String term) {

        return service.find(term);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AeronaveResponseDTO create(@Valid @RequestBody AeronaveCreateDTO aeronaveCreateDTO){
        return service.create(aeronaveCreateDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

}
