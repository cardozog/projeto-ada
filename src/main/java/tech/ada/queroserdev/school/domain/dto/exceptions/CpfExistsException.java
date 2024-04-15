package tech.ada.queroserdev.school.domain.dto.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CpfExistsException extends Exception {
    private final String cpf;
}
