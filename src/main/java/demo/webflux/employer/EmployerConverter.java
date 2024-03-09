package demo.webflux.employer;

import demo.webflux.employee.EmployeeHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployerConverter {

    private final EmployeeHandler employeeHandler;
    public Mono<EmployerResponse> mapToEmployerResponse(Employer employer) {
        return Flux.fromIterable(employer.getEmployeeIdList())
                .flatMap(employeeId -> employeeHandler.findById(UUID.fromString(employeeId)))
                .collectList()
                .map(employeeResponses -> new EmployerResponse(
                        employer.getId(),
                        employer.getName(),
                        employer.getDescriptionMetadata(),
                        employeeResponses
                ));
    }

    public Mono<EmployerResponse> convertToMono(Mono<Employer> from){
        return from.flatMap(
                this::mapToEmployerResponse);
    }
}
