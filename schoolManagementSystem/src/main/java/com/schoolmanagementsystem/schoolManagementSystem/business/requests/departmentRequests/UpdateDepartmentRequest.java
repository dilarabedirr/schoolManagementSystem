package com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartmentRequest {

	private int departmentId;
	
	private String departmentName;

	private int departmentTypeId;
}
