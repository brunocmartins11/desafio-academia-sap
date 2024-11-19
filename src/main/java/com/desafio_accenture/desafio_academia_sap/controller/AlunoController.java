package com.desafio_accenture.desafio_academia_sap.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.desafio_accenture.desafio_academia_sap.dto.AlunoDTO;
import com.desafio_accenture.desafio_academia_sap.dto.CursoDTO;
import com.desafio_accenture.desafio_academia_sap.model.Aluno;
import com.desafio_accenture.desafio_academia_sap.model.Curso;
import com.desafio_accenture.desafio_academia_sap.populator.InscricaoPopulator;
import com.desafio_accenture.desafio_academia_sap.repository.AlunoRepository;
import com.desafio_accenture.desafio_academia_sap.repository.CursoRepository;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    public AlunoDTO cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setDataCadastro(alunoDTO.getDataCadastro() != null ? 
                              alunoDTO.getDataCadastro() : LocalDate.now());
        aluno = alunoRepository.save(aluno);
        return InscricaoPopulator.toAlunoDTO(aluno);
    }


    @PostMapping("/{alunoId}/inscrever/{cursoId}")
    public String inscreverAlunoEmCurso(@PathVariable Long alunoId, @PathVariable Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        Curso curso = cursoRepository.findById(cursoId)
            .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        aluno.getCursos().add(curso);
        alunoRepository.save(aluno);
        return "Aluno inscrito com sucesso no curso: " + curso.getNome();
    }
    
    @GetMapping("/{alunoId}/cursos")
    public List<CursoDTO> listarCursosDeAluno(@PathVariable Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
            .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        return aluno.getCursos().stream()
            .map(InscricaoPopulator::toCursoDTO)
            .collect(Collectors.toList());
    }
}
