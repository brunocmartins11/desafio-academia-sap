package com.desafio_accenture.desafio_academia_sap.dto;

import java.sql.Date;
import java.time.LocalDate;

public class CursoDTO {

    private Long id;
    private String nome;
    private String descricao;
    private LocalDate dataCadastro;

    public CursoDTO() {}
    

	public CursoDTO(Long id, String nome, String descricao, LocalDate dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataCadastro = dataCadastro;
	}

	// Getters e Setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
