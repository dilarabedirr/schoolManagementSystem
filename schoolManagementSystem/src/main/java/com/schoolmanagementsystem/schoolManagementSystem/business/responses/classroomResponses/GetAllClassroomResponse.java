package com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllClassroomResponse {

	private int classroomId;

	private String classroomName;

	private int classroomCapacity;

	private boolean status;

	private int classroomTypeId;

	private int departmentId;

}
