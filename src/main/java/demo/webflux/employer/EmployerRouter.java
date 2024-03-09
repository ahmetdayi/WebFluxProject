package demo.webflux.employer;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class EmployerRouter {

    @Bean
    @RouterOperations(
            @RouterOperation(
                    path = EmployerApiConstant.FIND_ALL,
                    method = RequestMethod.GET,
                    operation =
                    @Operation(
                            operationId = "findAllStudentWithCourses",
                            summary = "Find all students with courses",
                            description = "Find all students with courses",
                            responses =
                            @ApiResponse(
                                    responseCode = "200",
                                    description = "All students with courses",
                                    content = @Content(schema = @Schema(implementation = EmployerResponse.class))
                            )
                    )
            )
    )
    public RouterFunction<ServerResponse> route(EmployerHandler employerHandler){
        return RouterFunctions.nest(
                path(EmployerApiConstant.BASE),
                RouterFunctions.route(
                        GET(EmployerApiConstant.FIND_ALL)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::findAll)

                        .andRoute(GET(EmployerApiConstant.FIND_BY_ID)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::findById)

                        .andRoute(PUT(EmployerApiConstant.ADD_EMPLOYEE)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::addEmployee)

                        .andRoute(POST(EmployerApiConstant.CREATE_WITH_EMPTY_RESPONSE)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::createWithEmptyResponse)

                        .andRoute(DELETE(EmployerApiConstant.DELETE_BY_ID)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::deleteById)

                        .andRoute(PUT(EmployerApiConstant.UPDATE)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::update)
        );
    }

}
