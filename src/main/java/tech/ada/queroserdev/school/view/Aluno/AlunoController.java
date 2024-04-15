package tech.ada.queroserdev.school.view.Aluno;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.ada.queroserdev.school.domain.dto.exceptions.CpfExistsException;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;
import tech.ada.queroserdev.school.service.aluno.IAlunoService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

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
        return ok(servico.listarAlunos());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> buscarAluno(@PathVariable("id") int id) throws NotFoundException {

        return ok(servico.buscarAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDto> criarAluno(@RequestBody @Valid AlunoDto pedido) throws CpfExistsException {
        return ResponseEntity.status(HttpStatus.CREATED).body(servico.criarAluno(pedido));
    }

    @PostMapping("/aniversario/{id}")
    public AlunoDto incrementarIdades(@PathVariable("id") int id) throws NotFoundException {
        return servico.incrementarIdades(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> alterarAluno(@PathVariable("id") int id,
                                                 @RequestBody @Valid AlunoDto pedido) throws NotFoundException {
        final AlunoDto a = servico.atualizarAluno(id, pedido);

        return ok(a);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AlunoDto> excluirAluno(@PathVariable("id") int id) throws NotFoundException {
        AlunoDto alunoRemovido = servico.excluirAluno(id);
        if (alunoRemovido == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ok(alunoRemovido);
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<AlunoDto> buscarPorCpf(@PathVariable("cpf") String cpf) throws NotFoundException {
        return ResponseEntity.ok().body(servico.buscarPorCpf(cpf));
    }
}
