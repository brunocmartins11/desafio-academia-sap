package com.desafio_accenture.desafio_academia_sap.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.desafio_accenture.desafio_academia_sap.dto.AlunoDTO;
import com.desafio_accenture.desafio_academia_sap.dto.CursoDTO;
import com.desafio_accenture.desafio_academia_sap.model.Curso;
import com.desafio_accenture.desafio_academia_sap.populator.InscricaoPopulator;
import com.desafio_accenture.desafio_academia_sap.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public CursoDTO cadastrarCurso(@RequestBody CursoDTO cursoDTO) {
        Curso curso = new Curso();
        curso.setNome(cursoDTO.getNome());
        curso.setDescricao(cursoDTO.getDescricao());
        curso.setDataCadastro(cursoDTO.getDataCadastro() != null ? 
                              cursoDTO.getDataCadastro() : LocalDate.now());
        curso = cursoRepository.save(curso);
        return InscricaoPopulator.toCursoDTO(curso);
    }


    @GetMapping("/{cursoId}/alunos")
    public List<AlunoDTO> listarAlunosDeCurso(@PathVariable Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return curso.getAlunos().stream()
            .map(InscricaoPopulator::toAlunoDTO)
            .collect(Collectors.toList());
    }
}
