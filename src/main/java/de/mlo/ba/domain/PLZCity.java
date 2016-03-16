package de.mlo.ba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PLZCity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter
	@Getter
	private Long Id;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String plz;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String city;
	
	
}
