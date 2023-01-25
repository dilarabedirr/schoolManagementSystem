package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.HourService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Hour;

@RestController
@RequestMapping("/hours")
public class HoursController {

	private HourService hourService;

	@Autowired
	public HoursController(HourService hourService) {
		this.hourService = hourService;
	}

	@PostMapping("/add")
	Result add(Hour hour) {
		return this.hourService.add(hour);
	}

	@GetMapping("/getall")
	DataResult<List<Hour>> getAll() {
		return this.hourService.getAll();
	}
}
