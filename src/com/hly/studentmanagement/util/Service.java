package com.hly.studentmanagement.util;

import java.util.Scanner;

import com.hly.studentmanagement.dto.Student;
import com.hly.studentmanagement.mytoys.MyToys;

public class Service {
	
	public static String getID() {
		String regrexSE = "(?i)^[SE]{2}[0-9]{3}$";
		String regrexAI = "(?i)^[AI]{2}[0-9]{3}$";
		
		while(1>0) {
			try {
				System.out.print("Input your ID: ");
				String ID = MyToys.getAString();
				if(ID.matches(regrexSE) || ID.matches(regrexAI))
					return ID;
				System.out.println("ID must be have 'AI' or 'SE' at first and ID have 5 char");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static String getFirstName() {
		System.out.print("Your first name: ");
		return MyToys.getAString();
	}
	
	public static String getLastName() {
		System.out.print("Your last name: ");
		return MyToys.getAString();
	}
	
	public static int getYearOfBirth() {
		
		while (true) {
			System.out.print("Your year of birth: ");
			int yearOfBirth = MyToys.getInt();
			if(yearOfBirth >= 1000 && yearOfBirth <= 9999)
				return yearOfBirth;
		}
		
	}
	
	public static String getMajor() {
		while (true) {
			try {
				String regrexSE = "(?i)^SE";
				String regrexAI = "(?i)^AI";
				System.out.print("Your Major: ");
				String major = MyToys.getAString();
				
				if(major.matches(regrexAI) || major.matches(regrexSE))
					return major;
				System.out.println("Major must be SE or AI");
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
	}
	
	public static String getResidence() {
		System.out.print("Your residence: ");
		return MyToys.getAString();
	}
	
	public static int getSchoolYear() {
		
		while (true) {
			System.out.print("Your shool year: ");
			int schoolYear = MyToys.getInt();
			if(schoolYear >= 1000 && schoolYear <= 9999)
				return schoolYear;
		}
		
	}
	
	public static double getGPA() {
		while(true) {
			System.out.print("Your GPA: ");
			double gpa = MyToys.getDouble();
			if(gpa > 0 && gpa <= 10)
				return gpa;
		}
	}
	
	public static double getSalary() {
		while(true) {
			System.out.print("Your salary: ");
			double salary = MyToys.getDouble();
			if(salary >= 0)
				return salary;
		}
	}
	
	

}
