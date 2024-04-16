package tech.ada.queroserdev.school.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tech.ada.queroserdev.school.domain.dto.QuoteDto;

@Service
@FeignClient(name = "Quotes", url="https://api.chucknorris.io/jokes/random")
public interface FeignQuoteApi {
    @GetMapping
    QuoteDto getQuote();
}
