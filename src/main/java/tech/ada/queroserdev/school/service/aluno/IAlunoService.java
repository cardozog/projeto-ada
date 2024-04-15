package tech.ada.queroserdev.school.service.aluno;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.exceptions.CpfExistsException;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;
import tech.ada.queroserdev.school.domain.dto.v1.professor.ProfessorDto;

import java.util.List;


public interface IAlunoService {
    AlunoDto criarAluno(AlunoDto pedido) throws CpfExistsException;
    List<AlunoDto> listarAlunos();
    AlunoDto buscarAlunoPorId(int id) throws NotFoundException;
    AlunoDto atualizarAluno (int id, AlunoDto pedido) throws NotFoundException;
    AlunoDto excluirAluno(int id) throws NotFoundException;
    AlunoDto incrementarIdades(int id) throws NotFoundException;

    AlunoDto buscarPorCpf(String cpf) throws NotFoundException;
}
