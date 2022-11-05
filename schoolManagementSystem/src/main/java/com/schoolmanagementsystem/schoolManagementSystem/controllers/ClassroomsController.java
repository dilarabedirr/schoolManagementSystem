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

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.CreateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.DeleteClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.UpdateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetAllClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetByIdClassroomResponse;

@RestController
@RequestMapping("/classrooms")
public class ClassroomsController {

	private ClassroomService classroomService;

	@Autowired
	public ClassroomsController(ClassroomService classroomService) {
		this.classroomService = classroomService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateClassroomRequest createClassroomRequest) {
		this.classroomService.add(createClassroomRequest);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteClassroomRequest deleteClassroomRequest) {
		this.classroomService.delete(deleteClassroomRequest);
	}

	@PutMapping("/update")
	public void update(@RequestBody UpdateClassroomRequest updateClassroomRequest) {
		this.classroomService.update(updateClassroomRequest);
	}

	@GetMapping("/getall")
	public List<GetAllClassroomResponse> getAll() {
		return this.classroomService.getAll();
	}

	@GetMapping("/getbyid")
	public GetByIdClassroomResponse getById(int id) {
		return this.classroomService.getById(id);
	}

}
