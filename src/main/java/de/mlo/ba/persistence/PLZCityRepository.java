package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.PLZCity;

public interface PLZCityRepository extends JpaRepository<PLZCity, Long> {

}
