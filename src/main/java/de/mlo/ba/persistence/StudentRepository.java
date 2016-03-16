package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
