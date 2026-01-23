package com.aerobase.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema (description = "Dados de Criação da Aeronave")
public class AeronaveCreateDTO {

    @Schema(example = "KC-390")
    @NotBlank
    private String nome;

    @Schema(example = "Embraer")
    @NotBlank
    private String marca;

    @Schema(example = "1999")
    @NotNull
    private Integer ano;

    @Schema(example = "Adquirida por FAB")
    @NotBlank
    private String descricao;

    @Schema(example = "true")
    @NotNull
    private Boolean vendido;

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
}

