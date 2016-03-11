package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Institut;

public interface InstitutRepository extends JpaRepository<Institut, Long> {

}
