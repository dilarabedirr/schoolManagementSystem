package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.CreateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.DeleteClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.UpdateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetAllClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetByIdClassroomTypeResponse;

public interface ClassroomTypeService {
	
	void add(CreateClassroomTypeRequest classroomTypeRequest);
	
	void delete(DeleteClassroomTypeRequest deleteClassroomTypeRequest);
	
	void update(UpdateClassroomTypeRequest updateClassroomTypeRequest);

	List<GetAllClassroomTypeResponse> getAll();
	
	GetByIdClassroomTypeResponse getById(int id);
}
