package demo.webflux;

import demo.webflux.employer.Employer;
import demo.webflux.employer.EmployerRepository;
import demo.webflux.metadata.DescriptionConstant;
import demo.webflux.metadata.DescriptionMetadata;
import demo.webflux.metadata.EmployerDescriptionMetadata;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class WebfluxApplication implements CommandLineRunner {
    private final EmployerRepository employerRepository;

    public WebfluxApplication(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
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
    }
}
