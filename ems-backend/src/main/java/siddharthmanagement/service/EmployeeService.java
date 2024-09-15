package siddharthmanagement.service;

import siddharthmanagement.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employedId, EmployeeDto employeeDto);
    void deleteEmployee(Long employedId);
}
