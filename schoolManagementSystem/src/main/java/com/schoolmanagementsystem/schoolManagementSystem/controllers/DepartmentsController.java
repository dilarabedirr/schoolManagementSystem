package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.CreateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.DeleteDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.UpdateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetAllDepartmentResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetByIdDepartmentResponse;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

	private DepartmentService departmentService;

	public DepartmentsController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateDepartmentRequest createDepartmentRequest) {
		this.departmentService.add(createDepartmentRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteDepartmentRequest deleteDepartmentRequest) {
		this.departmentService.delete(deleteDepartmentRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateDepartmentRequest updateDepartmentRequest) {
		this.departmentService.update(updateDepartmentRequest);
	}

	@GetMapping("/getall")
	public List<GetAllDepartmentResponse> getAll() {
		return this.departmentService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdDepartmentResponse getById(int id) {
		return this.departmentService.getById(id);
	}

}
