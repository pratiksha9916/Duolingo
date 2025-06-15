package com.example.studentData.service;

import com.example.studentData.dao.Student;
import com.example.studentData.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;


	public Student addStudent(Student student){
		return repo.save(student);
	}

	public Student getStudentData(int id){
		return repo.findById(id).get();
	}

	public List<Student> getAllStudent(){
		return repo.findAll();
	}

	public Student updateStudent(int id,Student student){
		Student student1=repo.findById(id).get();
		student1.setName(student.getName());
		student1.setAddress(student.getAddress());
		student1.setAge(student.getAge());
		student1.setPhoneno(student.getPhoneno());
		return student1;
	}

	public boolean deleteStudent(int id){
		if(id!=0){
			repo.deleteById(id);
			return true;
		}
		else{
			return false;
		}
	}
}
