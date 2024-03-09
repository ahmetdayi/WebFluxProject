package demo.webflux.employer;

import demo.webflux.metadata.EmployerDescriptionMetadata;

public record CreateEmployerRequest(

        String name,
        EmployerDescriptionMetadata employerDescriptionMetadata
) {
}
