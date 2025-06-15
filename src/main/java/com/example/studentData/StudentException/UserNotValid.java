package com.example.studentData.StudentException;

public class UserNotValid  extends RuntimeException{
	public  UserNotValid (String msg){
		super(msg);
	}
}
