package de.mlo.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.ba.domain.Employee;
import de.mlo.ba.persistence.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/service/employees")
    public @ResponseBody
    List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }
    
    @RequestMapping(value="/service/employee/{id}", method=RequestMethod.GET)
    public @ResponseBody Employee getEmployeeById(@PathVariable Long id) {
        return this.employeeRepository.findOne(id);
    }

}
