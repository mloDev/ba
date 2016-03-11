package de.mlo.ba.bootfaces.domain;

import javax.persistence.*;

import de.mlo.ba.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	@Setter
	private Long id;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String matNo;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String matNoOld;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String surName;
	
	@Column(nullable = true)
	@Getter
	@Setter
	private String birthName;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String eMail;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	@Getter
	@Setter
	private Gender gender;
	

}
