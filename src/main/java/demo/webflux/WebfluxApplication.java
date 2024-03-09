package demo.webflux;

import demo.webflux.employee.Employee;
import demo.webflux.employee.EmployeeRepository;
import demo.webflux.employer.Employer;
import demo.webflux.employer.EmployerRepository;
import demo.webflux.metadata.DescriptionConstant;
import demo.webflux.metadata.DescriptionMetadata;
import demo.webflux.metadata.EmployeeDescriptionMetadata;
import demo.webflux.metadata.EmployerDescriptionMetadata;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication

public class WebfluxApplication implements CommandLineRunner {
    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;

    public WebfluxApplication(EmployerRepository employerRepository, EmployeeRepository employeeRepository) {
        this.employerRepository = employerRepository;
        this.employeeRepository = employeeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        employerRepository.save(new Employer(UUID.randomUUID(),"aaa", EmployerDescriptionMetadata.builder().
//                type(DescriptionConstant.EMPLOYER_DESCRIPTION_TYPE)
//                .company("aaa")
//                .employeeCount(1212)
//                .build())).block();
//        employeeRepository.save(new Employee(UUID.randomUUID(),"aaa", EmployeeDescriptionMetadata.builder().
//                type(DescriptionConstant.EMPLOYEE_DESCRIPTION_TYPE)
//                .jobTitle("asdasdsadasd")
//                .salary("1212")
//                .position("java")
//                .build(),false)).block();
    }
}
