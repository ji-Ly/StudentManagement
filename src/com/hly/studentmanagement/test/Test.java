package com.hly.studentmanagement.test;

import java.util.Scanner;

import com.hly.studentmanagement.dao.StudentDAO;
import com.hly.studentmanagement.dto.Student;
import com.hly.studentmanagement.mytoys.MyToys;
import com.hly.studentmanagement.util.Service;

public class Test {

	public static void main(String[] args) {

		StudentDAO st = new StudentDAO();

		int flag = 0;

		while (flag != 6) {

			MyToys.Menu();

			String key = new Scanner(System.in).nextLine();

			try {
				switch (key) {
				case "1": {
					st.addNewStudent();
					System.out.println("Student added successfully!");
					break;
				}
				case "2": {

					System.out.println(st.searchStudentByID(Service.getID()));


					break;
				}
				case "3": {
					st.deleteAStudentByUsingID(Service.getID());
					break;
				}
				case "4": {
					for (Student student : st.getAllStudent()) {
						System.out.println(student);
					}
		
					break;
				}
				case "5": {
					st.updateStudentGPAByUsingID(Service.getID());
					
					break;
				}
				case "6": {
					System.out.println("Exited!");
					flag = 6;
					break;
				}
				default:
					System.out.println("Please input number of 1-6: ");
					break;

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
