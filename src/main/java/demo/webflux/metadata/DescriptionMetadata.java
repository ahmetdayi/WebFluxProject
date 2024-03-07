package demo.webflux.metadata;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes(
        {
                @JsonSubTypes.Type(value = EmployeeDescriptionMetadata.class, name = DescriptionConstant.EMPLOYEE_DESCRIPTION_TYPE),
                @JsonSubTypes.Type(value = EmployerDescriptionMetadata.class, name = DescriptionConstant.EMPLOYER_DESCRIPTION_TYPE),
        }
)
@SuperBuilder
public class DescriptionMetadata {
        @JsonIgnore
        private String type;
}
