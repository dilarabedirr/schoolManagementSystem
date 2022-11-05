package com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepartmentRequest {

	@JsonIgnore
	private int departmentId;

	private String departmentName;

	private int departmentTypeId;
}
