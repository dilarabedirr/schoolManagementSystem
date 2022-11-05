package com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdDepartmentResponse {

	private int departmentId;
	private String departmentName;
	private int departmentTypeId;
}
