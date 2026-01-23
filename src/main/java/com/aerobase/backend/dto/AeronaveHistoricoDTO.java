package com.aerobase.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Instant;

@Schema(description = "Registro do histórico de Edição de Aeronave")
public class AeronaveHistoricoDTO {

    @Schema(example = "ano")
    private String campo;

    @Schema(example = "2016")
    private String valorAnterior;

    @Schema(example = "2018")
    private String valorNovo;

    @Schema(example = "2026-01-20 21:45:13")
    private Instant dataAlteracao;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(String valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    public String getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(String valorNovo) {
        this.valorNovo = valorNovo;
    }

    public Instant getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Instant dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}
