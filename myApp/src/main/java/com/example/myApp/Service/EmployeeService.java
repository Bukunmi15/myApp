package com.example.myApp.Service;

import com.example.myApp.Dto.EmployeeDto;
import com.example.myApp.Dto.UserDto;
import com.example.myApp.Model.Employee;
import com.example.myApp.Repository.EmployeeRepo;
import com.example.myApp.Response.EmployeeResponse;
import com.example.myApp.Response.UserResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;

    public EmployeeResponse addUser (EmployeeDto request){
        Employee employee = new Employee();
        employee.setSex(request.getSex());
        employee.setBranchId(request.getBranchId());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setDateCreated(new Date());
        employeeRepo.save(employee);
        return modelMapper.map(employee,EmployeeResponse.class);
    }


    public EmployeeResponse updateEmployee (Long id, EmployeeDto request){
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if(employeeOptional.isEmpty()){
            throw new RuntimeException("Employee Not Found");
        }else{
            Employee employee = employeeOptional.get();
            employee.setSex(request.getSex());
            employee.setBranchId(request.getBranchId());
            employee.setFirstName(request.getFirstName());
            employee.setLastName(request.getLastName());
            employee.setDateCreated(new Date());
            employeeRepo.save(employee);
            return modelMapper.map(employee,EmployeeResponse.class);
        }
    }


    public List<Employee> getEmployee(){
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }


    public String deleteEmployee(Long id){
        Optional<Employee> employeeOptional = employeeRepo.findById(id);
        if(employeeOptional.isEmpty()){
            throw new RuntimeException("No Employee Found In The System");
        }else{
            Employee employee = employeeOptional.get();
            employeeRepo.delete(employee);
            return "Successfully Deleted";
        }
    }
}
