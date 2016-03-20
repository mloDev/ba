package de.mlo.ba.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.security.access.prepost.PreAuthorize;

import de.mlo.ba.domain.Student;
import de.mlo.ba.persistence.StudentRepository;
import lombok.Getter;
import lombok.Setter;

@ManagedBean(name = "stModel", eager = true)
@RequestScoped
public class StudentModel {

	@ManagedProperty(value = "#{studentRepository}")
	@Setter
	@Getter
	StudentRepository studentRepository;

	@ManagedProperty(value = "#{student}")
	@Setter
	@Getter
	private StudentView student;

	@PreAuthorize("hasRole('ROLE_USER')")
	public String doCreateStudent() {
		Student created = new Student();
		created.setMatNo(this.student.getMatNo());
		created.setMatNoOld(this.student.getMatNoOld());
		created.setName(this.student.getName());
		created.setSurName(this.student.getSurName());
		created.setBirthName(this.student.getBirthName());
		created.setEMail(this.student.getEMail());
		created.setGender(this.student.getGender());
		Student newStudent = this.studentRepository.save(created);

		FacesContext.getCurrentInstance().addMessage("errors",
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Student created",
						"The Student " + created.getSurName() + " " + created.getName()
								+ " has been created with MatNr.:" + newStudent.getMatNo() + " and id="
								+ newStudent.getId()));

		Student student = new Student();
		setThisStudent(student);

		return "index.xhtml";
	}

	public void doFindStudentById() {
		Student found = studentRepository.findOne(this.student.getId());
		setThisStudent(found);
	}

	public List<StudentView> findAllStudents() {
		List<StudentView> students = new ArrayList<StudentView>();
		for (Student entity : this.studentRepository.findAll()) {
			StudentView view = new StudentView();
			view.setId(entity.getId());
			view.setName(entity.getName());
			view.setMatNo(entity.getMatNo());
			view.setMatNoOld(entity.getMatNoOld());
			view.setEMail(entity.getEMail());
			view.setGender(entity.getGender());
			view.setSurName(entity.getSurName());
			view.setReqList(entity.getReqList());
			students.add(view);
		}
		return students;
	}

	private void setThisStudent(Student student) {
		this.student.setId(student.getId());
		this.student.setName(student.getName());
		this.student.setMatNo(student.getMatNo());
		this.student.setMatNoOld(student.getMatNoOld());
		this.student.setEMail(student.getEMail());
		this.student.setGender(student.getGender());
		this.student.setSurName(student.getSurName());
		this.student.setReqList(student.getReqList());
	}

}
