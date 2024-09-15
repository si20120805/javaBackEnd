package siddharthmanagement.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import siddharthmanagement.dto.EmployeeDto;
import siddharthmanagement.entity.Employee;
import siddharthmanagement.exception.ResourceNotFoundException;
import siddharthmanagement.mapper.EmployeeMapper;
import siddharthmanagement.repository.EmployeeRepository;
import siddharthmanagement.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
   private EmployeeRepository employesRepository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee= employesRepository.save(employee);
        return EmployeeMapper.mapToEmployesDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employesRepository.findById(employeeId).orElseThrow(() ->
                new ResourceNotFoundException("Employee Not Found"));
        return EmployeeMapper.mapToEmployesDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
       List<Employee> employees = employesRepository.findAll();
//        the Stream.map() function is used to transform each element of a stream into another form.//
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployesDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employedId, EmployeeDto employeeDto) {
        Employee employee =  employesRepository.findById(employedId).orElseThrow(()->new ResourceNotFoundException("Employee Not Exist"));
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        // Here save perform both the save and update the Employee

        Employee updatedEmployeObj = employesRepository.save(employee);
        return EmployeeMapper.mapToEmployesDto(updatedEmployeObj);
    }

    @Override
    public void deleteEmployee(Long employedId) {
        Employee employee = employesRepository.findById(employedId).orElseThrow(()->new ResourceNotFoundException("Employee Not Exist"));
    employesRepository.deleteById(employedId);
    }
}
