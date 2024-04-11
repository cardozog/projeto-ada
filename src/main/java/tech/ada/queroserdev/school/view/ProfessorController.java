package tech.ada.queroserdev.school.view;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.professor.ProfessorDto;
import tech.ada.queroserdev.school.service.professor.IProfessorService;

import java.util.List;

@RestController()
@RequestMapping(value = "/professor")
public class ProfessorController {

    private final IProfessorService servico;

    @Autowired
    public ProfessorController(IProfessorService servico) {

        this.servico = servico;
    }


    @GetMapping
    public List<ProfessorDto> lerProfessores() {
        return servico.listarProfessores();
    }

    @PostMapping
    public int criarProfessor(@RequestBody @Valid ProfessorDto pedido) {
        return servico.criarProfessor(pedido);
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(@PathVariable("id") int id, @RequestBody ProfessorDto pedido) {
        servico.atualizarProfessor(id, pedido);
    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(@PathVariable("id") int id) throws NotFoundException {

        return servico.buscarProfessorPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirProfessor(@PathVariable("id") int id) throws NotFoundException {
        servico.excluirProfessor(id);
    }
}
