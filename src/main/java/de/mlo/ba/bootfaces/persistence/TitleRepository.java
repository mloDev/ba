package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {

}
