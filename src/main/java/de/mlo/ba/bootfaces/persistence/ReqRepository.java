package de.mlo.ba.bootfaces.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import de.mlo.ba.bootfaces.domain.Req;

public interface ReqRepository extends JpaRepository<Req, Long> {

}
