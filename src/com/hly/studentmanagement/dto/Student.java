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
@AllArgsConstructor
//@ToString(callSuper = true)
public class Student extends UniversityMember implements Serializable, Scholarship  {
	
	private int schoolYear;
//	private String scholarship;
	private double gpa;
	
	  

	
//	public String lookForScholarship() {
//		
//		if(gpa >= 9)
//			return "Full Scholarship";
//		if(gpa >= 8)
//			return "Partial Scholarship";
//		
//		return "Failed Scholarship";
//			
//	}


	@Override
	public void readBookAtLibrary() {
		System.out.println("Student can read and borrow!");
		
	}


	public Student(String iD, String fistName, String lastName, int yearOfBirth, String major, String residence,
			int schoolYear,  double gpa) {
		super(iD, fistName, lastName, yearOfBirth, major, residence);
		this.schoolYear = schoolYear;
		//this.scholarship = scholarship;
		this.gpa = gpa;
	}


	@Override
	public String getScholarship() {
		if(gpa >= 9)
			return "Full Scholarship";
		if(gpa >= 8)
			return "Partial Scholarship";
		
		return "Failed Scholarship";
	}


	@Override
	public String toString() {
		return "Student [schoolYear=" + schoolYear + ", gpa=" + gpa + ", ID=" + ID + ", fistName=" + fistName
				+ ", lastName=" + lastName + ", yearOfBirth=" + yearOfBirth + ", major=" + major + ", residence="
				+ residence + "]";
	}
	
	
	
	
	
}
