package com.design.dao;

public class DaoPatternDemo {

	public static void main(String []args) {
		StudentDaoImpl daoImpl = new StudentDaoImpl();
		
		for(Student student:daoImpl.getAllStudents()) {
			System.out.println("Student: [Roll No: "+student.getRollNo()+" , Name: "+student.getName()+"]");
		}
		
		Student student = daoImpl.getAllStudents().get(0);
		student.setName("Michael");
		daoImpl.updateStudent(student);
		
		daoImpl.getStudent(0);
		System.out.println("Student: [Roll No: "+student.getRollNo()+" , Name: "+student.getName()+"]");
	}
}
