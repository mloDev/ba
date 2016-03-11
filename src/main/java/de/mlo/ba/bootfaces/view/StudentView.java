package de.mlo.ba.bootfaces.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.bootfaces.domain.Student;

@ManagedBean(name = "student", eager = true)
@RequestScoped
public class StudentView extends Student {

    public StudentView() { }
}

