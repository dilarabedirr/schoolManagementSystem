package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.CreateDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.DeleteDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.UpdateDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses.GetAllDepartmentTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses.GetByIdDepartmentTypeResponse;

@RestController
@RequestMapping("/departmentTypes")
public class DepartmentTypesController {

	private DepartmentTypeService departmentTypeService;

	@Autowired
	public DepartmentTypesController(DepartmentTypeService departmentTypeService) {
		this.departmentTypeService = departmentTypeService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateDepartmentTypeRequest createDepartmentTypeRequest) {
		this.departmentTypeService.add(createDepartmentTypeRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteDepartmentTypeRequest deleteDepartmentTypeRequest) {
		this.departmentTypeService.delete(deleteDepartmentTypeRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateDepartmentTypeRequest updateDepartmentTypeRequest) {
		this.departmentTypeService.update(updateDepartmentTypeRequest);
	}

	@GetMapping("/getall")
	public List<GetAllDepartmentTypeResponse> getAll() {
		return this.departmentTypeService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdDepartmentTypeResponse getById(int id) {
		return this.departmentTypeService.getById(id);
	}

}
