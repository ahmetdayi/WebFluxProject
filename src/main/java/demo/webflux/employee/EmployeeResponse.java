package demo.webflux.employee;

import demo.webflux.metadata.DescriptionMetadata;

import java.util.UUID;

public record EmployeeResponse(
        UUID id,
        String name,
        DescriptionMetadata descriptionMetadata
) {
}
