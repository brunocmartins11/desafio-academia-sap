package com.desafio_accenture.desafio_academia_sap.populator;

import com.desafio_accenture.desafio_academia_sap.dto.AlunoDTO;
import com.desafio_accenture.desafio_academia_sap.dto.CursoDTO;
import com.desafio_accenture.desafio_academia_sap.model.Aluno;
import com.desafio_accenture.desafio_academia_sap.model.Curso;

public class InscricaoPopulator {

    public static AlunoDTO toAlunoDTO(Aluno aluno) {
        return new AlunoDTO(
            aluno.getId(),
            aluno.getNome(),
            aluno.getEmail(),
            aluno.getDataCadastro()
        );
    }

    public static CursoDTO toCursoDTO(Curso curso) {
        return new CursoDTO(
            curso.getId(),
            curso.getNome(),
            curso.getDescricao(),
            curso.getDataCadastro() 
        );
    }
}
