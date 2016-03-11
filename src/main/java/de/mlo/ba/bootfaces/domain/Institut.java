package de.mlo.ba.bootfaces.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Institut {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String shortName;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String instNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Getter
	@Setter
	private PLZCity plzCity;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String street;
	
}
