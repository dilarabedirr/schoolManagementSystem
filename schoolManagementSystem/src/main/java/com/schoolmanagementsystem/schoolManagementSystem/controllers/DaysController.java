package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DayService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.dayRequests.CreateDayRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.dayResponses.GetAllDayResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/days")
public class DaysController {

	private DayService dayService;

	@Autowired
	public DaysController(DayService dayService) {
		this.dayService = dayService;
	}

	@PostMapping("/add")
	Result add(CreateDayRequest createDayRequest) {
		return this.dayService.add(createDayRequest);
	}

	@GetMapping("/getall")
	DataResult<List<GetAllDayResponse>> getAll() {
		return this.dayService.getAll();
	}

}
