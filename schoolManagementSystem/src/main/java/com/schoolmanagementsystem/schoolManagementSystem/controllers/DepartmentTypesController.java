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
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

@RestController
@RequestMapping("/departmentTypes")
public class DepartmentTypesController {

	private DepartmentTypeService departmentTypeService;

	@Autowired
	public DepartmentTypesController(DepartmentTypeService departmentTypeService) {
		this.departmentTypeService = departmentTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CreateDepartmentTypeRequest createDepartmentTypeRequest) {
		return this.departmentTypeService.add(createDepartmentTypeRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteDepartmentTypeRequest deleteDepartmentTypeRequest) {
		return this.departmentTypeService.delete(deleteDepartmentTypeRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody UpdateDepartmentTypeRequest updateDepartmentTypeRequest) {
		return this.departmentTypeService.update(updateDepartmentTypeRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<GetAllDepartmentTypeResponse>> getAll() {
		return this.departmentTypeService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<GetByIdDepartmentTypeResponse> getById(int id) {
		return this.departmentTypeService.getById(id);
	}

}
