package com.schoolmanagementsystem.schoolManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.CreateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.DeleteClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.UpdateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetAllClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetByIdClassroomTypeResponse;

@RestController
@RequestMapping("/classroomTypes")
@CrossOrigin("http://localhost:3000")
public class ClassroomTypesController {

	private ClassroomTypeService classroomTypeService;

	@Autowired
	public ClassroomTypesController(ClassroomTypeService classroomTypeService) {
		this.classroomTypeService = classroomTypeService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateClassroomTypeRequest createClassroomTypeRequest) {
		classroomTypeService.add(createClassroomTypeRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteClassroomTypeRequest deleteClassroomTypeRequest) {
		classroomTypeService.delete(deleteClassroomTypeRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateClassroomTypeRequest updateClassroomTypeRequest) {
		classroomTypeService.update(updateClassroomTypeRequest);
	}

	@GetMapping("/getall")
	public List<GetAllClassroomTypeResponse> getAll() {
		return classroomTypeService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdClassroomTypeResponse getById(int id) {
		return classroomTypeService.getById(id);
	}

}
