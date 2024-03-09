package demo.webflux.employer;

import demo.webflux.metadata.DescriptionMetadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employer")
public class Employer implements Serializable, Persistable<UUID> {

    private UUID id;

    private String name;

    private DescriptionMetadata descriptionMetadata;

    private List<String> employeeIdList;

    @Transient
    private boolean isUpdated = false;
    @Override
    public UUID getId() {
        return id;
    }
    @Override
    public boolean isNew() {
        return !this.isUpdated || id == null;
    }

    public Employer(String name, DescriptionMetadata descriptionMetadata) {
        this.name = name;
        this.descriptionMetadata = descriptionMetadata;
    }
}
