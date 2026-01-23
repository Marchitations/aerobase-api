package com.aerobase.backend.model;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.Instant;

@Entity
@Table(name = "aeronave")
@SQLDelete(sql = "UPDATE aeronave SET deletado = now() WHERE id = ?")
@Where(clause = "deletado IS NULL")
public class Aeronave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "vendido", nullable = false)
    private Boolean vendido = false;

    @Column(name = "criado", nullable = false, updatable = false)
    private Instant criado;

    @Column(name = "atualizado", nullable = false)
    private Instant atualizado;

    @Column(name = "deletado")
    private Instant deletado;


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

    public Instant getDeletado() {
        return deletado;
    }

    public void setDeletado(Instant deletado) {
        this.deletado = deletado;
    }
}
