package tech.ada.queroserdev.school.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.ada.queroserdev.school.domain.dto.entities.Aluno;
@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Integer> {

    Optional<Aluno>  findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
