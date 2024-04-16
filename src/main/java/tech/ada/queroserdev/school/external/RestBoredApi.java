package tech.ada.queroserdev.school.external;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.ada.queroserdev.school.domain.dto.QuoteDto;

@Service
@RequiredArgsConstructor
public class RestBoredApi {
    private final RestTemplate restTemplate;


    public QuoteDto activity(){
        return restTemplate
                .getForEntity("https://www.boredapi.com/api/activity", QuoteDto.class)
                .getBody();
    }
}
