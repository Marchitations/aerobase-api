package com.aerobase.backend.controller;


import com.aerobase.backend.dto.AeronaveCreateDTO;
import com.aerobase.backend.dto.AeronaveEditDTO;
import com.aerobase.backend.dto.AeronaveHistoricoDTO;
import com.aerobase.backend.dto.AeronaveResponseDTO;
import com.aerobase.backend.service.AeronaveHistoricoService;
import com.aerobase.backend.service.AeronaveService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Aeronaves", description = "Operações Relacionadas a Aeronaves")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/aeronaves")
@AllArgsConstructor
public class AeronaveController{
    private final AeronaveHistoricoService aeronaveHistoricoService;
    private AeronaveService service;

    @Operation(summary = "Listar aeronaves",
            description = "Retorna todas as aeronaves não deletadas")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<AeronaveResponseDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Retorna aeronave",
            description = "Retorna os detalhes de uma aeronave")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public AeronaveResponseDTO findById(@PathVariable Long id){
        return service.findByID(id);
    }

    @Operation(summary = "Atualizar aeronave",
            description = "Atualiza os dados de uma aeronave não vendida")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public AeronaveResponseDTO update(@PathVariable Long id, @Valid @RequestBody AeronaveEditDTO aeronaveEditDTO){
        return service.update(id, aeronaveEditDTO);
    }

    @Operation(summary = "Buscar aeronaves por termo",
            description = "Retorna todas as aeronaves que contém o termo passado por parâmetro em um ou mais de seus campos")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/find")
    public List<AeronaveResponseDTO> find(
            @RequestParam String term) {

        return service.find(term);
    }

    @Operation(summary = "Criar aeronave",
            description = "Insere uma aeronave na aplicação")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AeronaveResponseDTO create(@Valid @RequestBody AeronaveCreateDTO aeronaveCreateDTO){
        return service.create(aeronaveCreateDTO);
    }

    @Operation(summary = "Excluir aeronave",
            description = "Realiza uma exclusão lógica da aeronave")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
        service.delete(id);
    }

    @Operation(summary = "Apresenta histórico",
            description = "Retorna o histórico de todas as alterações efetuadas em aeronaves")
    @GetMapping("/{id}/historico")
    public List<AeronaveHistoricoDTO> historico(@PathVariable Long id) {
        return aeronaveHistoricoService.buscarHistorico(id);
    }

}
