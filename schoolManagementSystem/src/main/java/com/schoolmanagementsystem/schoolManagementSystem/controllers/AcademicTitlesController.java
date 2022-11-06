package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.AcademicTitleService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.CreateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.DeleteAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.UpdateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetByIdAcademicTitleResponse;

@RestController
@RequestMapping("/api/academictitles")
public class AcademicTitlesController {

	private AcademicTitleService academicTitleService;

	@Autowired
	public AcademicTitlesController(AcademicTitleService academicTitleService) {
		this.academicTitleService = academicTitleService;
	}

	@PostMapping("/add")
	public void add(CreateAcademicTitleRequest createAcademicTitleRequest) {
		this.academicTitleService.add(createAcademicTitleRequest);
	}

	@PutMapping("/update")
	public void update(UpdateAcademicTitleRequest updateAcademicTitleRequest) {
		this.academicTitleService.update(updateAcademicTitleRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest) {
		this.academicTitleService.delete(deleteAcademicTitleRequest);
	}

	@GetMapping("/getall")
	public List<GetAllAcademicTitleResponse> getAll() {
		return this.academicTitleService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdAcademicTitleResponse getById(int id) {
		return this.academicTitleService.getById(id);
	}

}
