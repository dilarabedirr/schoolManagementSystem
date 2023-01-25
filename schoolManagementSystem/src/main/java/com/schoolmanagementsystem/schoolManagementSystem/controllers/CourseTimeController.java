package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.CourseTimeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.courseTimeRequests.CreateCourseTimeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.courseTimeResponses.GetAllCourseTimeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/coursetimes")
public class CourseTimeController {

	private CourseTimeService courseTimeService;

	@Autowired
	public CourseTimeController(CourseTimeService courseTimeService) {
		this.courseTimeService = courseTimeService;
	}

	@PostMapping("/add")
	public Result add(CreateCourseTimeRequest createCourseTimeRequest) {
		return this.courseTimeService.add(createCourseTimeRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllCourseTimeResponse>> getAll() {
		return this.courseTimeService.getAll();
	}

}
