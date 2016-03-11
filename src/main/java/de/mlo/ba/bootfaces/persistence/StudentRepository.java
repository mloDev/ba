package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
