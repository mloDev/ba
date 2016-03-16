package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
