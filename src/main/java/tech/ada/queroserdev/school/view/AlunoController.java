package tech.ada.queroserdev.school.view;

import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;
import tech.ada.queroserdev.school.domain.dto.v1.professor.ProfessorDto;
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
    public ResponseEntity<List<AlunoDto>> listarAlunos() {
        return ResponseEntity.ok(servico.listarAlunos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(@PathVariable("id") int id) throws NotFoundException {
        return ResponseEntity.ok(servico.buscarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(@RequestBody @Valid AlunoDto pedido) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> alterarAluno(@PathVariable("id") int id,
                                                 @RequestBody @Valid AlunoDto pedido)  throws NotFoundException{
        final AlunoDto a = servico.atualizarAluno(id, pedido);
        if (a == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(a);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> excluirAluno(@PathVariable("id") int id) throws NotFoundException {
        AlunoDto alunoRemovido = servico.excluirAluno(id);
        if (alunoRemovido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(alunoRemovido);
    }

}
