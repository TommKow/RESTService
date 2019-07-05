package pl.lama.REST.exeption;

public class EmployeeNotFoundException extends Exception {
    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}
