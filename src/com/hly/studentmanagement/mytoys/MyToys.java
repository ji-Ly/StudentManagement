package com.hly.studentmanagement.mytoys;

import java.util.Iterator;
import java.util.Scanner;

public class MyToys {
	
	 

	private static Scanner sc = new Scanner(System.in);

	public static void Menu() {
		System.out.println("       STUDENT MANAGEMENT");
		System.out.println("--------------------------------");
		System.out.println("1. Add new student");
		System.out.println("2. Search student by ID");
		System.out.println("3. Delete student by ID");
		System.out.println("4. Show all student");
		System.out.println("5. Update student GPA");
		System.out.println("6. Exit");
	}
	
	public static String getAString() {

		while (1 > 0) {
			try {
				String string = sc.nextLine();
				if (string.length() >= 1)
					return string;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static int getInt() {
		while (true) {
			try {
				int integer = Integer.parseInt(getAString());

				return integer;

			} catch (Exception e) {
				e.getStackTrace();
				System.out.println("Only number!");
				System.out.print("Input again: ");
			}
		}
	}

	public static double getDouble() {
		while (1 + 1 == 2) {
			try {

				double doub = Double.parseDouble(getAString());
				return doub;
			} catch (Exception e) {
				e.getStackTrace();
				System.out.println("Only number!");
				System.out.print("Input again: ");
			}
		}
	}

}
