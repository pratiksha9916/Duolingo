package com.example.studentData.StudentException;

import com.example.studentData.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExecptionHandler {

	@ExceptionHandler(UserNotValid.class)
	public ResponseEntity<ResponseStructure<String>> UserNotValidHandler(UserNotValid valid) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.BAD_REQUEST.value());
		structure.setMsg("User Not Valid");
		structure.setData(null);
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}

//	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> NoSuchElementExceptionHandler(NoSuchElementException valid) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setCode(HttpStatus.BAD_REQUEST.value());
		structure.setMsg(valid.getMessage());
		structure.setData(null);
		return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
	}


//	@ExceptionHandler(StudentNotFoundException.class)
//	public ResponseEntity<String> handleStudentNotFound(StudentNotFoundException ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//	}
@ExceptionHandler(StudentNotFoundException.class)
public ResponseEntity<ResponseStructure<String>> StudentNotFoundExceptionHandler(StudentNotFoundException ex) {
	ResponseStructure<String> structure = new ResponseStructure<>();
	structure.setCode(HttpStatus.BAD_REQUEST.value());
	structure.setMsg(ex.getMessage());
	structure.setData(null);
	return new ResponseEntity<>(structure, HttpStatus.BAD_REQUEST);
}


//	@ExceptionHandler(ItemUpdateException.class)
//	public ResponseEntity<String> handleItemUpdateException(ItemUpdateException ex) {
//		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}




