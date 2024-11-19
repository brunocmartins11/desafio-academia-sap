package com.desafio_accenture.desafio_academia_sap.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Inscricao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@Temporal(TemporalType.DATE)
	private Date dataInscricao;

}
