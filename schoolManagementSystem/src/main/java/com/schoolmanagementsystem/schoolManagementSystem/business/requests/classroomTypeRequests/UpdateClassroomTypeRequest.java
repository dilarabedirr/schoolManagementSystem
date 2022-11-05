package com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClassroomTypeRequest {
	
	private int classroomTypeId;
	private String classroomtypeDescription;

}
