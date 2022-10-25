package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.DepartmentType;

@RestController
@RequestMapping("/departmentTypes")
public class DepartmentTypesController {
	
	private DepartmentTypeService departmentTypeService;
	
	@Autowired
	public DepartmentTypesController(DepartmentTypeService departmentTypeService) {
		this.departmentTypeService=departmentTypeService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody DepartmentType departmentType) {
		departmentTypeService.add(departmentType);
	}
	
	@GetMapping("/getAll")
	public List<DepartmentType> getAll(){
		return departmentTypeService.getAll();
	}

}
