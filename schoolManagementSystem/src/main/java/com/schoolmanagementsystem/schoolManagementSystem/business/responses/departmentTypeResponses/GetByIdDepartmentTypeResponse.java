package com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdDepartmentTypeResponse {
	private int id;
	private String departmentTypeDescription;
}
