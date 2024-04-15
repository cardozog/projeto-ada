package tech.ada.queroserdev.school.domain.dto.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.web.bind.MethodArgumentNotValidException;
import tech.ada.queroserdev.school.domain.dto.exceptions.CpfExistsException;
import tech.ada.queroserdev.school.domain.dto.exceptions.NotFoundException;

import java.util.Collection;
import java.util.stream.Collectors;

//resposta criada para enviar ao exception handler
@Data
public class ErrorResponse {

    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Collection<ErrorMessage> errors;

    private ErrorResponse(String message) {
        this.message = message;
    }

    private ErrorResponse(String message, Collection<ErrorMessage> errors) {
        this(message);
        this.errors = errors;
    }


    // vai criar uma exceção a partir dessa função lá no exception handler
    public static ErrorResponse createFromException(NotFoundException ex) {
        String message = "Nenhum registro de " + ex.getClazz().getSimpleName() + " encontrado através do valor " + ex.getId();
        return new ErrorResponse(message);
    }

    public static ErrorResponse createFromException(MethodArgumentNotValidException ex) {
        var violations = ex.getFieldErrors()
                .stream()
                .map(cv -> new ErrorMessage(cv.getField(), cv.getDefaultMessage()))
                .collect(Collectors.toList());

        return new ErrorResponse("Validation errors", violations);
    }

    public static ErrorResponse createFromException(CpfExistsException ex){
        String message = "O CPF " + ex.getCpf() +" já existe no banco de dados.";
        return new ErrorResponse(message);
    }
}
