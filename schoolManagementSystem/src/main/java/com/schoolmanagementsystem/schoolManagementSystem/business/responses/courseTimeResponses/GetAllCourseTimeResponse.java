package com.schoolmanagementsystem.schoolManagementSystem.business.responses.courseTimeResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCourseTimeResponse {

	private int courseTimeId;
	private String departmentName;
	private String day;
	private String hour;
	private boolean courseTimeStatus;

}
