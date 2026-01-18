package com.aerobase.backend.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "aeronave")
public class Aeronave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String marca;
    private Integer ano;
    private String descricao;
    private Boolean vendido;
    private Instant criado = Instant.now();
    private Instant atualizado = Instant.now();


    @PrePersist
    protected void onCreate() {
        this.criado = Instant.now();
        this.atualizado = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizado = Instant.now();
    }

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
