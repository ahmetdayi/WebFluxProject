package demo.webflux.employer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class EmployerRouter {

    @Bean
    //TODO https://www.youtube.com/watch?v=bEtgsJETiTQ for swagger integration
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
                        .andRoute(POST(EmployerApiConstant.CREATE_WITH_RESPONSE)
                                        .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::createWithResponse)
                        .andRoute(DELETE(EmployerApiConstant.DELETE_BY_ID)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::deleteById)

                        .andRoute(PUT(EmployerApiConstant.UPDATE)
                                .and(accept(MediaType.APPLICATION_JSON))
                                ,employerHandler::update)
        );
    }

}
