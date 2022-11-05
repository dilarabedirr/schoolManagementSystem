package com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDepartmentTypeResponse {
	
	private int id;
	private String departmentTypeDescription;

}
