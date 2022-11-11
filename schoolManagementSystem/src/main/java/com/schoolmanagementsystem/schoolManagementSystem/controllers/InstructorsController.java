package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.InstructorService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.CreateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.DeleteInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.UpdateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetAllInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetByIdInstructorResponse;

@RestController
@RequestMapping("/instructors")
public class InstructorsController {

	private InstructorService instructorService;

	@Autowired
	public InstructorsController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@PostMapping("/add")
	public void add(CreateInstructorRequest createInstructorRequest) {
		this.instructorService.add(createInstructorRequest);
	}

	@DeleteMapping("/delete")
	public void delete(DeleteInstructorRequest deleteInstructorRequest) {
		this.instructorService.delete(deleteInstructorRequest);
	}

	@PutMapping("/update")
	public void update(UpdateInstructorRequest updateInstructorRequest) {
		this.instructorService.update(updateInstructorRequest);
	}

	@GetMapping("/getall")
	public List<GetAllInstructorResponse> getAll() {
		return this.instructorService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdInstructorResponse getById(int id) {
		return this.instructorService.getById(id);
	}

}
