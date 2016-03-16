package de.mlo.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.mlo.ba.domain.Student;
import de.mlo.ba.persistence.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping("/service/students")
    public @ResponseBody
    List<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }
    
    @RequestMapping(value="/service/student/{id}", method=RequestMethod.GET)
    public @ResponseBody Student getStudentById(@PathVariable Long id) {
        return this.studentRepository.findOne(id);
    }
}
