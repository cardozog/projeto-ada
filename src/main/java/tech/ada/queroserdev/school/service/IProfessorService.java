package tech.ada.queroserdev.school.service;

import tech.ada.queroserdev.school.domain.dto.v1.ProfessorDto;

import java.util.List;

public interface IProfessorService {
    int criarProfessor(String nome);
    List<ProfessorDto> listarProfessores();
    ProfessorDto buscarProfessorPorId(int id);

    void atualizarProfessor(int id,String nome);
}
