package com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClassroomTypeResponse {
	
	private int id;
	private String classroomTypeDescription;

}
