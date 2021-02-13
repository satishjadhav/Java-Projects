package com.design.mvc;

public class StudentController {
	private Student student;
	private StudentView studentView;
	
	public StudentController(Student student,StudentView studentView) {
		this.student = student;
		this.studentView = studentView;
	}
	
	public void setStudentName(String name) {
		student.setName(name);
	}
	
	public String getStudentName() {
		return student.getName();
	}
	
	public void setStudentRollNo(String rollNo) {
		student.setRollNo(rollNo);
	}
	
	public String getStudentRollNo() {
		return student.getRollNo();
	}
	
	public void updateView() {
		studentView.printStudentDetails(student.getName(), student.getRollNo());
	}
}
