package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomService;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Classroom;

@RestController
@RequestMapping("/classrooms")
public class ClassroomsController {
	
	private ClassroomService classroomService;
	
	@Autowired
	public ClassroomsController(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}
	
	@PostMapping("/add")
	public void add(@RequestBody Classroom classroom) {
		classroomService.add(classroom);
	}
	
	@GetMapping("/getAll")
	public List<Classroom> getAll(){
		return classroomService.getAll();
	}

}
