package de.mlo.ba.bootfaces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.mlo.ba.bootfaces.domain.Employee;
import de.mlo.ba.bootfaces.persistence.EmployeeRepository;

public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/service/students")
    public @ResponseBody
    List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }
    
    @RequestMapping(value="/service/student/{id}", method=RequestMethod.GET)
    public @ResponseBody Employee getEmployeeById(@PathVariable Long id) {
        return this.employeeRepository.findOne(id);
    }

}
