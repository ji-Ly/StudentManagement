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
@ToString
public class Lecturer extends UniversityMember implements Serializable {
	
	private double salary;

	@Override
	public void readBookAtLibrary() {
		System.out.println("Lectuter just read not borrow!");
		
	}

}
