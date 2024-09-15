package siddharthmanagement.mapper;

import siddharthmanagement.dto.EmployeeDto;
import siddharthmanagement.entity.Employee;

public class EmployeeMapper {
//    going to frontEnd
    public static EmployeeDto mapToEmployesDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee( EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}

