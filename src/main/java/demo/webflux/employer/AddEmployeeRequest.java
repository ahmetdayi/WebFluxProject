package demo.webflux.employer;

import java.util.List;
import java.util.UUID;

public record AddEmployeeRequest(
        UUID employerId,
        List<UUID> employeeIdList
) {
}
