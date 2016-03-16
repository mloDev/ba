package de.mlo.ba.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Title {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Setter
	@Getter
	private Long id;
	
	@Column(nullable = false)
	@Setter
	@Getter
	private String title;
	
	@Column(nullable = false)
	@Setter
	@Getter
	private boolean degrade;

}
