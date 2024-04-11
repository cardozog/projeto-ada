package tech.ada.queroserdev.school.service.professor;

import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.professor.ProfessorDto;

import java.util.List;

public interface IProfessorService {
    int criarProfessor(ProfessorDto pedido);
    List<ProfessorDto> listarProfessores();
    ProfessorDto buscarProfessorPorId(int id) throws NotFoundException;

    void atualizarProfessor(int id,ProfessorDto pedido);

    void excluirProfessor(int id) throws NotFoundException;


}
