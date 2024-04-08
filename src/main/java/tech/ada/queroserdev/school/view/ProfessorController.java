package tech.ada.queroserdev.school.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.school.domain.dto.v1.ProfessorDto;
import tech.ada.queroserdev.school.service.IProfessorService;

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
    public int criarProfessor(@RequestBody ProfessorDto pedido) {
        return servico.criarProfessor(pedido.getNome());
    }

    @PutMapping("/{id}")
    public void atualizarProfessor(@PathVariable("id") int id, @RequestBody ProfessorDto pedido) {
        servico.atualizarProfessor(id, pedido.getNome());
    }

    @GetMapping("/{id}")
    public ProfessorDto buscarProfessor(
            @PathVariable("id") int id
    ) {
        return servico.buscarProfessorPorId(id);
    }

}
