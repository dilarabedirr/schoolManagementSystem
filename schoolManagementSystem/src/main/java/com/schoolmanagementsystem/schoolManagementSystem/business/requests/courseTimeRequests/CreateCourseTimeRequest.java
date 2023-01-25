package com.schoolmanagementsystem.schoolManagementSystem.business.requests.courseTimeRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCourseTimeRequest {

	@JsonIgnore
	private int courseTimeId;

	private boolean courseTimeStatus;

	private int departmentId;

	private int dayId;

	private int hourId;

}
