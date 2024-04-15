package tech.ada.queroserdev.school.service.aluno;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements IAlunoService {
    private final List<AlunoDto> alunos = new ArrayList<>();
    private int id = 1;

    @Override
    public AlunoDto criarAluno(AlunoDto pedido) {
        AlunoDto aluno = new AlunoDto(id++, pedido.getNome(), pedido.getCpf(), pedido.getEmail(), pedido.getIdade());
        alunos.add(aluno);
        return aluno;
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return alunos;
    }

    @Override
    public AlunoDto buscarAlunoPorId(int id) throws NotFoundException {
        return alunos.stream().filter(it -> it.getId() == id)
                .findFirst()
                .orElseThrow(
                        () -> new NotFoundException(AlunoDto.class, String.valueOf(id)
                        ));

    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException {
        AlunoDto aluno = buscarAlunoPorId(id);

        aluno.setNome(pedido.getNome() != null ? pedido.getNome() : aluno.getNome());
        aluno.setCpf(pedido.getCpf() != null ? pedido.getCpf() : aluno.getCpf());
        aluno.setEmail(pedido.getEmail() != null ? pedido.getEmail() : aluno.getEmail());
        aluno.setIdade(pedido.getIdade() != 0 ? pedido.getIdade() : aluno.getIdade());

        return aluno;


    }

    @Override
    public AlunoDto excluirAluno(int id) throws NotFoundException {
        AlunoDto aluno = buscarAlunoPorId(id);
        alunos.remove(aluno);
        return aluno;

    }

    @Override
    public AlunoDto incrementarIdades(int id) throws NotFoundException {
        AlunoDto aluno = buscarAlunoPorId(id);
        aluno.setIdade(aluno.getIdade() + 1);
        return aluno;
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return null;
    }
}