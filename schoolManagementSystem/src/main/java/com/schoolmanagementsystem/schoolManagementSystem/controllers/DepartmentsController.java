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
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

	private DepartmentService departmentService;

	public DepartmentsController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateDepartmentRequest createDepartmentRequest) {
		return this.departmentService.add(createDepartmentRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteDepartmentRequest deleteDepartmentRequest) {
		return this.departmentService.delete(deleteDepartmentRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody UpdateDepartmentRequest updateDepartmentRequest) {
		return this.departmentService.update(updateDepartmentRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllDepartmentResponse>> getAll() {
		return this.departmentService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<GetByIdDepartmentResponse> getById(int id) {
		return this.departmentService.getById(id);
	}

}
