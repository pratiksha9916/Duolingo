package com.example.studentData.cotroller;

import com.example.studentData.ResponseStructure;
import com.example.studentData.StudentException.StudentNotFoundException;
import com.example.studentData.StudentException.UserNotValid;
import com.example.studentData.dao.Student;
import com.example.studentData.service.StudentService;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class StudentController {

	@Autowired
	StudentService service;


//	Create
	@PostMapping("/student")
//	public Student getStudent(@RequestBody Student student){
//		return service.addStudent(student);
//	}
	public ResponseEntity<ResponseStructure<Student>> saveEmp(@RequestBody Student student) {
		Student savedStudent = service.addStudent(student);

		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.OK.value());
		structure.setMsg("Successfully Added");
		structure.setData(savedStudent);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}


//Read
	@GetMapping("/student/{id}")
//	public Student getStudData(@PathVariable("id") int id) {
//		return service.getStudentData(id);
//	}

	public ResponseEntity<ResponseStructure<Student>> getStudData(@PathVariable("id") int id) {
		Student studData = service.getStudentData(id);

		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setMsg("Get Data Successfully");
		structure.setData(studData);
		return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
	}
//Read All
	@GetMapping("/allstudent")
//	public List<Student> getAllData(Student student){
//		return service.getAllStudent();
//	}
	public ResponseEntity<ResponseStructure<List<Student>>> getAllData() {
	List<Student> studData = service.getAllStudent();

		ResponseStructure<List<Student>> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.OK.value());
		structure.setMsg("Fetched All Students Successfully");
		structure.setData(studData);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}


//	Update
	@PutMapping("/updateStudent/{id}")
//	public Student updateStudentData(@PathVariable("id") int id ,@RequestBody Student student){
//		return service.updateStudent(id,student);
//	}
	public ResponseEntity<ResponseStructure<Student>> getStudData(@PathVariable("id") int id,@RequestBody Student student) {
		Student studData1 = service.updateStudent(id,student);

		ResponseStructure<Student> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.ACCEPTED.value());
		structure.setMsg("Update Data Successfully");
		structure.setData(studData1);
		return new ResponseEntity<>(structure, HttpStatus.ACCEPTED);
	}


//	Delete
	@DeleteMapping("deleteStudent/{id}")
//	public boolean deletestudent(@PathVariable("id") int id){
//		return service.deleteStudent(id);
//	}

	public ResponseEntity<ResponseStructure<Boolean>> deleteStudent(@PathVariable("id") int id) {
		boolean studData2 = service.deleteStudent(id);

		ResponseStructure<Boolean> structure = new ResponseStructure<>();

		structure.setCode(HttpStatus.OK.value());
		structure.setMsg("Delete Data Successfully");
		structure.setData(studData2);
		return new ResponseEntity<>(structure, HttpStatus.OK);
	}

@PostMapping("/userData")
	public Student StudentException(@RequestBody Student student) {
	if (student.getId() != 0 && student.getName() != null && student.getAddress() != null && student.getAge() != 0 && student.getPhoneno() != 0) {
		return service.addStudent(student);
	} else {
		throw new UserNotValid("User Not Valid");
	}
}

//@GetMapping("/userNotFound/{id}")
//	public Student studExcep(@PathVariable("id")int id){
////	Student student=service.getStudentData(id);
//	if(id!= 0 ){
//		System.out.println("Use Not Found");
//		Student student=service.getStudentData(id);
//		return student;
//	}
//	else{
//		throw new NoSuchElementException("User Not Valid");
//	}
//}
@GetMapping("/userNotFound/{id}")
public Student studExcep(@PathVariable("id") int id) {
	Student student = service.getStudentData(id);

	if (student.getId() == id) {
		System.out.println("Student Not Found");

		return student;
	}
else{
		throw new NoSuchElementException("Student with ID " + id + " not found.");
	}

}


	@GetMapping("/students")
	public List<Student> getAllStudents() {
		List<Student> students = service.getAllStudent();

		if (students == null || students.isEmpty()) {
			throw new StudentNotFoundException("No students found in the database.");
		}

		return students;
	}

//	@PutMapping("/{id}")
//	public ResponseEntity<String> updateItem(@PathVariable("id") int id, @RequestBody Student student) {
//		if (student == null || student.getName() == null) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid item data");
//		}
//
//		boolean updated = updateItemInDatabase(id,student);
//		if (!updated) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found or update failed");
//		}
//
//		return ResponseEntity.ok("Item updated successfully");
//	}
//
//	private boolean updateItemInDatabase(int id, AbstractReadWriteAccess. Student student) {
//		// Mock logic: simulate update success or failure
//		return false; // Simulating failure
//	}
}


