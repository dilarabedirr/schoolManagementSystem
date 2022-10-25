package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.ClassroomType;

@RestController
@RequestMapping("/classroomTypes")
public class ClassroomTypesController {
	
	private ClassroomTypeService classroomTypeService;
	
	@Autowired
	public ClassroomTypesController(ClassroomTypeService classroomTypeService) {
		this.classroomTypeService=classroomTypeService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody ClassroomType classroomType) {
		classroomTypeService.add(classroomType);
	}
	
	@GetMapping("/getAll")
	public List<ClassroomType> getAll(){
		return classroomTypeService.getAll();
	}

}
