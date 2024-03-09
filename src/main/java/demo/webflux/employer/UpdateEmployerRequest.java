package demo.webflux.employer;

import java.util.UUID;

public record UpdateEmployerRequest(
        UUID id,
        String name
) {
}
