package demo.webflux.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeHandler {

    private final EmployeeRepository employeeRepository;

    public Mono<EmployeeResponse> findById(UUID id){
        return employeeRepository.findById(id)
                .map(employee -> new EmployeeResponse(
                        employee.getId(),
                        employee.getName(),
                        employee.getDescriptionMetadata())
                );
    }
}
