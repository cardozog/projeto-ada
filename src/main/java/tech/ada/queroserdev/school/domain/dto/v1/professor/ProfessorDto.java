package tech.ada.queroserdev.school.domain.dto.v1.professor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ProfessorDto {

    private int id;
    @NotBlank
    private String nome;
    @CPF
    @NotNull
    private String cpf;
    @Email
    @NotNull
    private String email;
}
