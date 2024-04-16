package tech.ada.queroserdev.school.domain.dto.mappers;

import tech.ada.queroserdev.school.domain.dto.entities.Aluno;
import tech.ada.queroserdev.school.domain.dto.v1.aluno.AlunoDto;
import tech.ada.queroserdev.school.external.RestBoredApi;

public class AlunoMapper {
    public static Aluno toEntity(AlunoDto dto) {
        return Aluno
                .builder()
                .nome(dto.getNome())
                .cpf(dto.getCpf())
                .eMail(dto.getEmail())
                .idade(dto.getIdade())
                .build();
    }

    public static AlunoDto toDto(Aluno aluno,String activity) {
        return new AlunoDto(aluno.getId(), aluno.getNome(), aluno.getCpf(), aluno.getEMail(), aluno.getIdade(),activity );
    }
}
