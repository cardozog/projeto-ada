package tech.ada.queroserdev.school.service;

import org.springframework.stereotype.Service;
import tech.ada.queroserdev.school.domain.dto.v1.ProfessorDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {

    private final List<ProfessorDto> professores = new ArrayList<>();
    private int id = 1;

    @Override
    public int criarProfessor(String nome) {
        professores.add(new ProfessorDto(id++, nome));
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
    public void atualizarProfessor(int id, String nome) {
        Optional<ProfessorDto> professor = professores.stream().filter(prof -> prof.getId() == id).findFirst();
        if (professor.isPresent()) {
            professor.get().setNome(nome);

        }

    }
}
