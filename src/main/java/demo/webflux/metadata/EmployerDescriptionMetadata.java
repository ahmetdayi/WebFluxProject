package demo.webflux.metadata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class EmployerDescriptionMetadata extends DescriptionMetadata{

    private Integer employeeCount;

    private String company;


}
