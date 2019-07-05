package pl.lama.REST.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lama.REST.domain.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
