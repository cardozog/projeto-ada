package tech.ada.queroserdev.school.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import tech.ada.queroserdev.school.domain.dto.ActivityDto;

@Service
@FeignClient(name = "Activities", url="https://www.boredapi.com/api/activity")
public interface FeignBoredApi {
    @GetMapping
    ActivityDto getActivity();
}
