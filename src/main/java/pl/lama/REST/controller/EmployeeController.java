package pl.lama.REST.controller;

import org.springframework.web.bind.annotation.*;
import pl.lama.REST.domain.model.Employee;
import pl.lama.REST.exeption.EmployeeNotFoundException;
import pl.lama.REST.repositories.EmployeeRepository;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/employees")
    List<Employee> all() {
        return employeeRepository.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) throws EmployeeNotFoundException {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }
    @PutMapping("/employee/{id}")
    Employee editEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return employeeRepository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return employeeRepository.save(newEmployee);
                });
    }
    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
