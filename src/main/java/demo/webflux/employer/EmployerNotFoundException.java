package demo.webflux.employer;

public class EmployerNotFoundException extends RuntimeException  {

    public EmployerNotFoundException(String message) {
        super(message);
    }
}
