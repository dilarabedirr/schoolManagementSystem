package com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results;

public class Result {
	
	private boolean success;// true ya da false
	private String message; // mesaj bilgisi
	
	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
