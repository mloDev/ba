package de.mlo.ba.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import de.mlo.ba.domain.Student;

@ManagedBean(name = "student", eager = true)
@RequestScoped
public class StudentView extends Student {

    public StudentView() { }
}

