package demo.webflux.employee;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends R2dbcRepository<Employee, UUID> {
    Mono<Employee> findByIdIn(List<UUID> uuidList);

}
