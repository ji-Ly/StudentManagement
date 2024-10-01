package com.hly.studentmanagement.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@ToString
public abstract class UniversityMember implements Serializable {
	
	protected String ID;
	protected String fistName;
	protected String lastName;
	protected int yearOfBirth;
	protected String major;
	protected String residence;
	
	
	
	public abstract void readBookAtLibrary();



	public UniversityMember(String iD, String fistName, String lastName, int yearOfBirth, String major,
			String residence) {
		super();
		ID = iD;
		this.fistName = fistName;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
		this.major = major;
		this.residence = residence;
	}
}
