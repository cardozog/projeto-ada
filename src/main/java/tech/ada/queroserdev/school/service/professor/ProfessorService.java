package tech.ada.queroserdev.school.service.professor;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.v1.professor.ProfessorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {

    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(ProfessorDto pedido) {
        professores.add(new ProfessorDto(id++, pedido.getNome(), pedido.getCpf(), pedido.getEmail()));
        return id - 1;
    }

    @Override
    public List<ProfessorDto> listarProfessores() {

        return professores;
    }

    @Override
    public ProfessorDto buscarProfessorPorId(int id) {
        Optional<ProfessorDto> professor = professores
                .stream()
                .filter(it -> it.getId() == id)
                .findFirst();
        return professor.orElse(null);
    }

    @Override
    public void atualizarProfessor(int id, ProfessorDto pedido) {
        Optional<ProfessorDto> professor = professores.stream().filter(prof -> prof.getId() == id).findFirst();
        if (professor.isPresent()) {
            professor.get().setNome(pedido.getNome());
            professor.get().setCpf(pedido.getCpf());
            professor.get().setEmail(pedido.getEmail());
        }

    }

    @Override
    public void excluirProfessor(int id) {
        ProfessorDto professor = buscarProfessorPorId(id);
        if (professor != null) {
            professores.remove(professor);
        }
    }
}