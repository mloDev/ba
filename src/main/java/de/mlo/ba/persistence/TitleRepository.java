package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Title;

public interface TitleRepository extends JpaRepository<Title, Long> {

}
