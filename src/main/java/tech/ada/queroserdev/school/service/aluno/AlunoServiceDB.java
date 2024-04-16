package tech.ada.queroserdev.school.service.aluno;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.queroserdev.school.domain.dto.entities.Aluno;
import tech.ada.queroserdev.school.domain.dto.exceptions.CpfExistsException;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;
import tech.ada.queroserdev.school.domain.dto.mappers.AlunoMapper;
import tech.ada.queroserdev.school.external.FeignBoredApi;
import tech.ada.queroserdev.school.external.RestBoredApi;
import tech.ada.queroserdev.school.repositories.AlunoRepository;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;

import java.util.List;


@Service
@RequiredArgsConstructor
@Primary
public class AlunoServiceDB implements IAlunoService {

    private final AlunoRepository repository;
    private final FeignBoredApi boredApi;



    @Override
    public AlunoDto criarAluno(AlunoDto pedido) throws CpfExistsException {
        if (repository.existsByCpf(pedido.getCpf())) {
            throw new CpfExistsException(pedido.getCpf());
        }

        Aluno a = AlunoMapper.toEntity(pedido);
        return AlunoMapper.toDto(repository.save(a),boredApi.getActivity().activity());
    }

    @Override
    public List<AlunoDto> listarAlunos() {
        return repository
                .findAll()
                .stream()
                .map(ent -> AlunoMapper.toDto(ent, boredApi.getActivity().activity()))
                .toList();
    }

    @Override
    public AlunoDto buscarAlunoPorId(int id) throws NotFoundException {
        return AlunoMapper.toDto(buscarAluno(id), boredApi.getActivity().activity());
    }

    @Override
    public AlunoDto atualizarAluno(int id, AlunoDto pedido) throws NotFoundException, CpfExistsException {
        final Aluno a = buscarAluno(id);
        if (a.getCpf() == pedido.getCpf()) {
            throw new CpfExistsException(pedido.getCpf());
        }
        a.setCpf(pedido.getCpf());
        a.setNome(pedido.getNome());
        a.setEMail(pedido.getEmail());
        a.setIdade(pedido.getIdade());
        return AlunoMapper.toDto(repository.save(a), boredApi.getActivity().activity());
    }

    @Override
    public void excluirAluno(int id) throws NotFoundException {
        final Aluno a = buscarAluno(id);
        repository.delete(a);

    }


    @Override
    public AlunoDto incrementarIdades(int id) throws NotFoundException {
        final Aluno a = buscarAluno(id);
        a.setIdade(a.getIdade() + 1);
        return AlunoMapper.toDto(repository.save(a), boredApi.getActivity().activity());
    }

    @Override
    public AlunoDto buscarPorCpf(String cpf) throws NotFoundException {
        return AlunoMapper.toDto(repository.findByCpf(cpf).orElseThrow(() -> new NotFoundException(Aluno.class, cpf)),boredApi.getActivity().activity());
    }

    @Override
    public void excluirAluno(String cpf) throws NotFoundException {
        AlunoDto aluno = buscarPorCpf(cpf);
        repository.delete(AlunoMapper.toEntity(aluno));

    }

    private Aluno buscarAluno(int id) throws NotFoundException {
        return repository
                .findById(id)
                .orElseThrow(() -> new NotFoundException(Aluno.class, String.valueOf(id)));
    }


}
