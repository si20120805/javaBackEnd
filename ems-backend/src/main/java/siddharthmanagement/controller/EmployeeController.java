package siddharthmanagement.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import siddharthmanagement.dto.EmployeeDto;
import siddharthmanagement.service.EmployeeService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    //Bulid and Add Employee RestAPI
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        System.out.println("dddddddddddddddd1111111111111111"+employeeDto.getFirstName());
    EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

     return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //Build Get Employee REST API
    @GetMapping("/{id}")
public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {

        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);

}
//Build a collection of All the employes


    @GetMapping
   public ResponseEntity<List<EmployeeDto>> getAllEmployees() {

     List<EmployeeDto> employees = employeeService.getAllEmployees();
     return ResponseEntity.ok(employees);
   }

  @PutMapping("{id}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto) {
      System.out.println("dddddddddddddddd1111111111111111" + employeeId);
      EmployeeDto employeeDto1 = employeeService.updateEmployee(employeeId, employeeDto);
      return ResponseEntity.ok(employeeDto1);
   }
@DeleteMapping("{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully");
   }
}

