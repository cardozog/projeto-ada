package tech.ada.queroserdev.school.view;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;
import tech.ada.queroserdev.school.service.aluno.IAlunoService;

import java.util.List;

@RestController()
@RequestMapping(value = "/aluno")
public class AlunoController {
    private final IAlunoService servico;

    @Autowired
    public AlunoController(IAlunoService servico) {
        this.servico = servico;
    }

    @GetMapping
    public List<AlunoDto> listarAlunos(){
        return servico.listarAlunos();
    }
    @GetMapping(value = "/{id}")
    public AlunoDto buscarAluno(@PathVariable("id")int id){
        return servico.buscarAlunoPorId(id);
    }

    @PostMapping
    public int criarAluno(@RequestBody @Valid AlunoDto pedido) {
        return servico.criarAluno(pedido);
    }

    @PutMapping(value = "/{id}")
    public void alterarAluno(@PathVariable("id") int id, @RequestBody @Valid AlunoDto pedido){
        servico.atualizarAluno(id,pedido);
    }
    @DeleteMapping(value = "/{id}")
    public void excluirAluno(@PathVariable("id")int id){
        servico.excluirAluno(id);
    }

}
