package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.PLZCity;

public interface PLZCityRepository extends JpaRepository<PLZCity, Long> {

}
