package tech.ada.queroserdev.school.service.aluno;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarAluno(AlunoDto pedido) {
        alunos.add(new AlunoDto(id++, pedido.getNome(), pedido.getCpf(), pedido.getEmail()));
        return id - 1;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAlunoPorId(int id) {
        Optional<AlunoDto> aluno = alunos.stream().filter(it -> it.getId() == id).findFirst();
        return aluno.orElse(null);
    }

    @Override
    public void atualizarAluno(int id, AlunoDto pedido) {
        Optional<AlunoDto> aluno = alunos.stream().filter(al -> al.getId() == id).findFirst();
        if (aluno.isPresent()) {
            aluno.get().setNome(pedido.getNome());
            aluno.get().setCpf(pedido.getCpf());
            aluno.get().setEmail(pedido.getEmail());
        }
    }

    @Override
    public void excluirAluno(int id) {
        AlunoDto aluno = buscarAlunoPorId(id);
        if (aluno != null) {
            alunos.remove(aluno);
        }
    }
}
