package com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAcademicTitleRequest {
	
	@JsonIgnore
	private int academicTitleId;
	
	private String academicTitle;
	
	private String shortName;

}
