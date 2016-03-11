package de.mlo.ba.bootfaces.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.bootfaces.domain.Employee;

@ManagedBean(name = "employee", eager = true)
@RequestScoped
public class EmployeeView extends Employee {
	
	public EmployeeView() {};

}
