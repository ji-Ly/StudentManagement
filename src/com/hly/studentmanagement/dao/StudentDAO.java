package com.hly.studentmanagement.dao;

import java.awt.font.FontRenderContext;
import java.io.Serializable;
import java.security.Provider.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.hly.studentmanagement.dto.Student;
import com.hly.studentmanagement.mytoys.MyToys;
import com.hly.studentmanagement.util.DBUtil;

public class StudentDAO implements Serializable {

	private com.hly.studentmanagement.util.Service service = new com.hly.studentmanagement.util.Service();
	private Connection connection = DBUtil.makeConnection();
	private static StudentDAO instance;

	public StudentDAO() {
	}

	public static StudentDAO getInstance() {
		if (instance == null)
			instance = new StudentDAO();
		return instance;
	}

// add a student
	public void addNewStudent() {
		PreparedStatement preparedStatement = null;

		try {
			connection = DBUtil.makeConnection();
			String query = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, getIdNonExisted(service.getID()));
			preparedStatement.setString(2, service.getFirstName());
			preparedStatement.setString(3, service.getLastName());
			preparedStatement.setInt(4, service.getYearOfBirth());
			preparedStatement.setString(5, service.getMajor());
			preparedStatement.setInt(6, service.getSchoolYear());
			preparedStatement.setString(7, service.getResidence());
			preparedStatement.setDouble(8, service.getGPA());

			preparedStatement.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null && !connection.isClosed() )
					connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		System.out.println("Student Updated Successfully");

	}

	// get ID non existed
	public String getIdNonExisted(String ID) {

		List<String> listStudentID = new ArrayList<String>();

		while (true) {

			try {
				// Connection connection = DBUtil.makeConnection();
				PreparedStatement preparedStatement = null;

				String query = "select id from student";

				preparedStatement = connection.prepareStatement(query);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {

					String studentID = rs.getString("ID");
					listStudentID.add(studentID);
				}

//				for (String stuID : listStudentID) {
//					System.out.println(stuID);
//				}
//				for(int i = 0; i < listStudentID.size(); i++) {
//					System.out.println(listStudentID.get(i));
//				}
				
			

				
				while (true) {

					boolean found = false;
					for (int j = 0; j < listStudentID.size(); j++) {
						if (listStudentID.get(j).equalsIgnoreCase(ID)) {
							System.out.println("ID existed!");
							found = true;
						}

					}
					if (found == false)
						return ID;
					ID = service.getID();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		

		}

	}

	// check ID
	// if ID doesn't existed before then return ID
	public String checkID(String ID) {
		PreparedStatement preparedStatement = null;
		String query = "select id from student";
		List<String> studentList = new ArrayList<String>();
		try {
			preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String studentID = rs.getString("ID");
				studentList.add(studentID);
			}

			

			for (int i = 0; i < studentList.size(); i++) {
				if (studentList.get(i).equalsIgnoreCase(ID))
					return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ID;
	}

	// get all student
	public List<Student> getAllStudent() {

		PreparedStatement preparedStatement = null;
		String query = "select * from student";
		List<Student> students = new ArrayList<>();

		try {
			preparedStatement = connection.prepareStatement(query);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String studentID = rs.getString("ID");
				String studentFirstName = rs.getString("Fisrt Name");
				String studentLastName = rs.getString("Last Name");
				int studentYOB = rs.getInt("Year Of Birth");
				String studentMajor = rs.getString("Marjor");
				int studentShoolYear = rs.getInt("School Year");
				String studentResidence = rs.getString("Residence");
				double studentGPA = rs.getDouble("GPA");

				Student student = new Student(studentID, studentFirstName, studentLastName, studentYOB, studentMajor,
						studentResidence, studentShoolYear, studentGPA);

				students.add(student);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}

	// search a student by ID
	public List<Student> searchStudentByID(String ID) {
		if (checkID(ID) != null)
			System.out.println("ID doesn't exist!");;
		PreparedStatement preparedStatement = null;
		connection = null;
		String query = "select * from student where id = ?";

		List<Student> students = new ArrayList<Student>();
		try {
			connection = DBUtil.makeConnection();

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, ID);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String studentID = rs.getString("ID");
				String studentFirstName = rs.getString("Fisrt Name");
				String studentLastName = rs.getString("Last Name");
				int studentYOB = rs.getInt("Year Of Birth");
				String studentMajor = rs.getString("Marjor");
				int studentShoolYear = rs.getInt("School Year");
				String studentResidence = rs.getString("Residence");
				double studentGPA = rs.getDouble("GPA");

				Student student = new Student(studentID, studentFirstName, studentLastName, studentYOB, studentMajor,
						studentResidence, studentShoolYear, studentGPA);

				students.add(student);
			}

		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}
	
	//delete a student by ID
	public void deleteAStudentByUsingID(String ID) {
//		if(checkID(ID) != null)// ham checkID tra ve null neu ID ton tai
//			System.out.println("ID not existed"); // neu khac null thi tra ve null luon 
		PreparedStatement preparedStatement = null;
		String query = "delete from student where id = ?";
		try {
			connection = DBUtil.makeConnection();
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, ID);
			int rowAffactied = preparedStatement.executeUpdate();
			
			if(rowAffactied > 0)
				System.out.println("Student has ID: " + ID +" has been deleted");
			else
				System.out.println("ID do not exist!");
			
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//updateGPA
	public List<Student> updateStudentGPAByUsingID(String ID) {
		// kiem tra ID dua vao ton tai hay chua
		// ham checkID tra ve null neu ID ton tai
		
		if(checkID(ID) != null) {
			System.out.println("ID existed!");// khac null thi khong ton tai va tra ve null
			return null;
		}
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String query = "update student set gpa = ? where id = ?";
		
		List<Student> students = new ArrayList<Student>();
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, service.getGPA());
			preparedStatement.setString(2, ID);
		   int rowAffected = preparedStatement.executeUpdate();
			
		   if(rowAffected > 0) {
			   String selectQuery = "Select * from student where id = ?";
			   preparedStatement = connection.prepareStatement(selectQuery);
			   preparedStatement.setString(1, ID);
			   rs = preparedStatement.executeQuery();
			   
			   while(rs.next()) {
					String studentID = rs.getString("ID");
					String studentFirstName = rs.getString("Fisrt Name");
					String studentLastName = rs.getString("Last Name");
					double studentGPA = rs.getDouble("GPA");
					
					Student student = new Student();
					student.setID(studentID);
					student.setFistName(studentFirstName);
					student.setLastName(studentLastName);
					student.setGpa(studentGPA);
					
					students.add(student);
		   }
			   
			
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Student updated successfully!");
		return students;
		
		
	}
	
	
	

	public static void main(String[] args) {

		StudentDAO stu = new StudentDAO();
		System.out.println(		stu.updateStudentGPAByUsingID(com.hly.studentmanagement.util.Service.getID())
);

//		for (Student string : stu.getAllStudent()) {
//			System.out.println(string);
//		}
		
//		for (Student string : stu.updateStudentGPAByUsingID("se123")) {
//			System.out.println(string);
//			
//		}

		//System.out.println(stu.checkID("se123"));

		//stu.deleteAStudentByUsingID("se234");
		//System.out.println(stu.getIdNonExisted("se123"));
		//stu.addNewStudent();
		}

	

}
