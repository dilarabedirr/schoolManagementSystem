package com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetByIdAcademicTitleResponse {

	private int id;

	private String academicTitle;

	private String shortName;
}
