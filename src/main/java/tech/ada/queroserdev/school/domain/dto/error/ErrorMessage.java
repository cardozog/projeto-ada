package tech.ada.queroserdev.school.domain.dto.error;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
//mensagem a ser enviada para a resposta De erro
public class ErrorMessage {
    private String field;
    private String message;
}
