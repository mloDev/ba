package de.mlo.ba.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.domain.Employee;

@ManagedBean(name = "employee", eager = true)
@RequestScoped
public class EmployeeView extends Employee {
	
	public EmployeeView() {};

}
