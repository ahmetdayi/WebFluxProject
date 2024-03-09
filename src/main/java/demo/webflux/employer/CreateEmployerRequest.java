package demo.webflux.employer;

import demo.webflux.metadata.DescriptionMetadata;

public record CreateEmployerRequest(
        String name,
        DescriptionMetadata descriptionMetadata
) {
}
