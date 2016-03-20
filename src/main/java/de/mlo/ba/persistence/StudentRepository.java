package de.mlo.ba.persistence;

import org.springframework.data.repository.CrudRepository;

import de.mlo.ba.domain.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
