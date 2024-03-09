package demo.webflux.employer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployerHandler {

    private final EmployerRepository employerRepository;
    private final EmployerConverter employerConverter;

    //region Different Create Method
    public Mono<ServerResponse> createWithResponse(ServerRequest request) {
        Mono<CreateEmployerRequest> createEmployerRequestMono = request.bodyToMono(CreateEmployerRequest.class);
        Mono<Employer> savedEmployer = createEmployerRequestMono
                .flatMap(request1 -> employerRepository
                        .save(new Employer(request1.name(), request1.descriptionMetadata())));

        return ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(savedEmployer, Employer.class);
    }


    /*
     * void method for create
     *
     * */
    public Mono<Void> createWithoutResponse(ServerRequest request) {

        return request.bodyToMono(CreateEmployerRequest.class)
                .flatMap(request1 -> employerRepository.save(new Employer(request1.name(), request1.descriptionMetadata())))
                .then(ServerResponse.status(HttpStatus.CREATED).build()).then();
    }

    /*
     * empty response for create
     * */
    public Mono<ServerResponse> createWithEmptyResponse(ServerRequest request) {
        return request.bodyToMono(CreateEmployerRequest.class)
                .flatMap(request1 -> employerRepository
                        .save(new Employer(request1.name(), request1.descriptionMetadata())))
                .then(ServerResponse.status(HttpStatus.CREATED).build());
    }
    //endregion

    //region Update
    /*
     * void update
     * */
    public Mono<ServerResponse> update(ServerRequest request) {
        Mono<UpdateEmployerRequest> requestMono = request.bodyToMono(UpdateEmployerRequest.class);

        return requestMono
                .flatMap(updateEmployerRequest -> {
                    String employerId = updateEmployerRequest.id().toString();
                    return findByIdMono(employerId)
                            .flatMap(employer -> updateEmployerName(employer, updateEmployerRequest));
                })
                .then(ServerResponse.status(HttpStatus.CREATED).build());
    }

    private Mono<Employer> updateEmployerName(Employer employer, UpdateEmployerRequest uRequest) {
        employer.setName(uRequest.name().trim().isEmpty() ? employer.getName() : uRequest.name());
        return employerRepository.save(employer);
    }
    //endregion

    //region FindAll
    public Mono<ServerResponse> findAll(ServerRequest request) {
        Flux<EmployerResponse> employerResponseFlux = employerRepository.findAll()
                .flatMap(employerConverter::mapToEmployerResponse);
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(employerResponseFlux, EmployerResponse.class);
    }
    //endregion

    public Mono<ServerResponse> findById(ServerRequest request){
        //TODO pathvariableden aldigin id string gelmesi lazim
        String id = request.pathVariable("id");
        Mono<EmployerResponse> employerResponseMono = employerConverter.convertToMono(findByIdMono(id));
        return ServerResponse
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(employerResponseMono, EmployerResponse.class);
        };

    public Mono<Void> deleteById(ServerRequest request) {
        String id = request.pathVariable("id");
        return findByIdMono(id)
                .flatMap(employerRepository::delete)
                .then(ServerResponse.status(HttpStatus.OK).build()).then();
    }

    private Mono<Employer> findByIdMono(String id) {
        return employerRepository.
                findById(UUID.fromString(id))
                .switchIfEmpty(Mono.error(new EmployerNotFoundException(Constant.EMPLOYER_NOT_FOUND)));
    }


}
