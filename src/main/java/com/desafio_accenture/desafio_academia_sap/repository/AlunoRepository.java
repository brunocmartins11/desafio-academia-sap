package com.desafio_accenture.desafio_academia_sap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio_accenture.desafio_academia_sap.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{}
