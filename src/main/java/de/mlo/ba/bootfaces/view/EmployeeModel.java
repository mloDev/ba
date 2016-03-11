package de.mlo.ba.bootfaces.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import de.mlo.ba.bootfaces.domain.Employee;
import de.mlo.ba.bootfaces.persistence.EmployeeRepository;


@ManagedBean(name = "empModel", eager = true)
@RequestScoped
public class EmployeeModel {
	
    @ManagedProperty(value = "#{employeeRepository}")
    EmployeeRepository employeeRepository;
    
    @ManagedProperty(value = "#{employee}")
    private EmployeeView employee;

	    public void setEmployee(EmployeeView employee) {
	        this.employee = employee;
	    }

	    public EmployeeView getEmployee() {
	        return employee;
	    }

	    public EmployeeRepository getEmployeeRepository() {
	        return employeeRepository;
	    }

	    public void setemployeeRepository(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
	    }

	    public String doCreateEmployee() {
	        Employee created = new Employee();
	        setThisEmployee(created, this.employee);
	        Employee newEmployee = this.employeeRepository.save(created);

	        FacesContext.getCurrentInstance().addMessage("errors",
	            new FacesMessage(FacesMessage.SEVERITY_INFO, "employee created",
	                "The employee " + created.getSurName() + " " + created.getName() + " has been created with id: " + newEmployee.getId()));

	        Employee employee = new Employee();
	        setThisEmployee(this.employee, employee);

	        return "index.xhtml";
	    }

	    public void doFindEmployeeById() {
	        Employee found = employeeRepository.findOne(this.employee.getId());
	        setThisEmployee(this.employee, found);
	    }

	    public List<EmployeeView> findAllEmployees() {
	        List<EmployeeView> employees = new ArrayList<EmployeeView>();
	        for(Employee entity : this.employeeRepository.findAll()) {
	            EmployeeView view = new EmployeeView();
	            setThisEmployee(view, entity);
	            employees.add(view);
	        }
	        return employees;
	    }
	    
	    public void validateTitle() {
	    	
	    }
	    
	    private void setThisEmployee(Employee employee, Employee setEmployee) {
	        employee.setId(setEmployee.getId());
	        employee.setTitle(setEmployee.getTitle());
	        employee.setName(setEmployee.getName());
	        employee.setEMail(setEmployee.getEMail());
	        employee.setGender(setEmployee.getGender());
	        employee.setSurName(setEmployee.getSurName());
	        employee.setEmployment(setEmployee.getEmployment());
	        employee.setHomepage(setEmployee.getHomepage());
	        employee.setInstitut(setEmployee.getInstitut());
	        employee.setMobilNo(setEmployee.getMobilNo());
	        employee.setPlzCity(setEmployee.getPlzCity());
	        employee.setPrivEMail(setEmployee.getPrivEMail());
	        employee.setStreet(setEmployee.getStreet());
	    }

}
