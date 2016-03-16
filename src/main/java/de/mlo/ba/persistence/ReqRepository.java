package de.mlo.ba.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.domain.Req;

public interface ReqRepository extends JpaRepository<Req, Long> {

}
