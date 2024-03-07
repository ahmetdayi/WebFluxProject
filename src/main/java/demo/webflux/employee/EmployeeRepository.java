package demo.webflux.employee;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface EmployeeRepository extends R2dbcRepository<Employee, UUID> {
}
