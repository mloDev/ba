package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
