package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

}
