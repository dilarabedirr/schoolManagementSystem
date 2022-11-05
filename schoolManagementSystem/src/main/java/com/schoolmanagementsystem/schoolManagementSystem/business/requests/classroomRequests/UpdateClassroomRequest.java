package com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClassroomRequest {

	private int classroomId;

	private String classroomName;

	private int classroomCapacity;

	private boolean status;

	private int classroomTypeId;

	private int departmentId;

}
