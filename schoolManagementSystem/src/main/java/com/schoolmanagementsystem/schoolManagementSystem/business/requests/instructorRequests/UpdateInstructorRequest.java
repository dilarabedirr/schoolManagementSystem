package com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
	
	private int id;

	private String firstName;

	private String lastName;

	private String mail;

	private String address;

	private String phone;

	private int academicTitleId;

	private int departmentId;

}
