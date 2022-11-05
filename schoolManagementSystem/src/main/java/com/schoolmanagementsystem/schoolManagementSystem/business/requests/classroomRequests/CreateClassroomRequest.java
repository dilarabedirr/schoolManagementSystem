package com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassroomRequest {
	
	@JsonIgnore
	private int classroomId;
	
	private String classroomName;
	
	private int classroomCapacity;
	
	private boolean status;
	
	private int classroomTypeId;
	
	private int departmentId;
}
