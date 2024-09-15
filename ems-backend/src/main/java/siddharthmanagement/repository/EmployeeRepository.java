package siddharthmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import siddharthmanagement.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
