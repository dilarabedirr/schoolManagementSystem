package com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClassroomTypeResponse {
	
	private int classroomTypeId;
	private String classroomTypeDescription;

}
