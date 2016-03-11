package de.mlo.ba.bootfaces.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.data.neo4j.annotation.Fetch;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Req {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter
	@Getter
	private Long id;
	
	@Column(nullable = true)
	@Setter
	@Getter
	private String name;

	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@Setter
	@Getter
	private Student student;

}
