package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Employment;

public interface EmploymentRepository extends JpaRepository<Employment, Long> {

}
