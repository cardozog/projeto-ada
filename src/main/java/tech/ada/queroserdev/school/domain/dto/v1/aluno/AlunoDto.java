package tech.ada.queroserdev.school.domain.dto.v1.aluno;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
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
public class AlunoDto {

    private int id;
    @NotBlank
    private String nome;
    @CPF
    @NotBlank
    private String cpf;
    @Email
    @NotBlank
    private String email;
    private int idade;

    @Null
    private String activity;
}
