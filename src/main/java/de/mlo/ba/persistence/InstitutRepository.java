package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Institut;

public interface InstitutRepository extends JpaRepository<Institut, Long> {

}
