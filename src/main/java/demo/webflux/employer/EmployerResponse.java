package demo.webflux.employer;

import demo.webflux.employee.EmployeeResponse;
import demo.webflux.metadata.DescriptionMetadata;

import java.util.List;
import java.util.UUID;

public record EmployerResponse(
        UUID id,
        String name,
        DescriptionMetadata descriptionMetadata,
        List<EmployeeResponse> employeeList
) {
}
