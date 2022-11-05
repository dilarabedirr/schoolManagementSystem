package com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDepartmentTypeRequest {
	
	private int departmentTypeId;
	private String departmentTypeDescription;

}
