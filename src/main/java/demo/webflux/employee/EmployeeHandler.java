package demo.webflux.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
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

    public Mono<List<String>> findExistIdInIdList(List<UUID> idList) {
        return Flux.fromIterable(idList)
                .flatMap(employeeRepository::findById)
                .mapNotNull(Employee::getId)
                .mapNotNull(UUID::toString)
                .collectList();
    }
}
