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
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/instructors")
public class InstructorsController {

	private InstructorService instructorService;

	@Autowired
	public InstructorsController(InstructorService instructorService) {
		this.instructorService = instructorService;
	}

	@PostMapping("/add")
	public Result add(CreateInstructorRequest createInstructorRequest) {
		return this.instructorService.add(createInstructorRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(DeleteInstructorRequest deleteInstructorRequest) {
		return this.instructorService.delete(deleteInstructorRequest);
	}

	@PutMapping("/update")
	public Result update(UpdateInstructorRequest updateInstructorRequest) {
		return this.instructorService.update(updateInstructorRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllInstructorResponse>> getAll() {
		return this.instructorService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<GetByIdInstructorResponse> getById(int id) {
		return this.instructorService.getById(id);
	}

}
