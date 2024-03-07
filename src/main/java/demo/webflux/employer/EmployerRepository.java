package demo.webflux.employer;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

import java.util.UUID;

public interface EmployerRepository extends R2dbcRepository<Employer, UUID> {
}
