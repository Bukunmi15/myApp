package com.example.myApp.Controller;

import com.example.myApp.Dto.EmployeeDto;
import com.example.myApp.Model.Employee;
import com.example.myApp.Response.EmployeeResponse;
import com.example.myApp.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bank/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping("employee")
    public EmployeeResponse addUser(@RequestBody EmployeeDto request){
            return employeeService.addUser(request);
    }

    @PutMapping("updateEmployee")
    public EmployeeResponse updateEmployee(@RequestBody EmployeeDto request, @RequestParam("id") Long id){
        return employeeService.updateEmployee(id, request);
    }

    @GetMapping("getEmployee")
    public List<Employee> getEmployee(){
        return employeeService.getEmployee();
    }

    @DeleteMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("id") Long id){
        return employeeService.deleteEmployee(id);
    }

}
