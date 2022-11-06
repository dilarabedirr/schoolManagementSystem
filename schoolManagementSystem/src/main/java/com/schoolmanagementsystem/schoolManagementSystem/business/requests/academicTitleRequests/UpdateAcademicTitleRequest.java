package com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAcademicTitleRequest {

	private int academicTitleId;

	private String academicTitle;

	private String shortName;

}
