package tech.ada.queroserdev.school.service.aluno;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;

import java.util.List;


public interface IAlunoService {
    int criarAluno(AlunoDto pedido);
    List<AlunoDto> listarAlunos();
    AlunoDto buscarAlunoPorId(int id);
    void atualizarAluno(int id, AlunoDto pedido);
    void excluirAluno(int id);
}
