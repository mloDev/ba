package de.mlo.ba.domain;

import java.util.Set;

import javax.persistence.*;

import de.mlo.ba.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
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
	
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Getter
	@Setter
	private Set<Req> reqList;
	
    @Override
    public boolean equals(Object object) {
        return (object instanceof Student) && (id != null) 
             ? id.equals(((Student) object).id) 
             : (object == this);
    }
	

}
