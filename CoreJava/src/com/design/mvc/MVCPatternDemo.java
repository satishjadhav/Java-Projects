package com.design.mvc;

public class MVCPatternDemo {
	public static void main(String []args) {
		
		Student model = retriveStudentFromDatabse();
		
		StudentView studentView  =new StudentView();
		
		StudentController controller = new StudentController(model, studentView);
		controller.updateView();
		
		controller.setStudentName("John");
		controller.updateView();
	}
	
	private static Student retriveStudentFromDatabse() {
		Student student = new Student();
		student.setName("Robert");
		student.setRollNo("10");
		return student;
	}
}
