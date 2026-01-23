package com.aerobase.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Schema(description = "Dados da Aeronave")
public class AeronaveResponseDTO {

    @Schema(example = "1")
    private Long id;

    @Schema(example = "E195-E2")
    private String nome;

    @Schema(example = "Embraer")
    private String marca;

    @Schema(example = "2022")
    private Integer ano;

    @Schema(example = "Vendido para Imanary Company LTDA.")
    private String descricao;

    @Schema(example = "true")
    private Boolean vendido;

    @Schema(example = "2026-01-22 19:45:08")
    private Instant criado;

    @Schema(example = "2026-01-22 19:54:55")
    private Instant atualizado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getVendido() {
        return vendido;
    }

    public void setVendido(Boolean vendido) {
        this.vendido = vendido;
    }

    public Instant getCriado() {
        return criado;
    }

    public void setCriado(Instant criado) {
        this.criado = criado;
    }

    public Instant getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Instant atualizado) {
        this.atualizado = atualizado;
    }
}
