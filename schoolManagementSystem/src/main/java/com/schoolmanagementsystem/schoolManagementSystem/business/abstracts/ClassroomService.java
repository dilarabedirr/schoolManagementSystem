package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.CreateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.DeleteClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.UpdateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetAllClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetByIdClassroomResponse;

public interface ClassroomService {
	void add(CreateClassroomRequest createClassroomRequest);

	void delete(DeleteClassroomRequest deleteClassroomRequest);

	void update(UpdateClassroomRequest updateClassroomRequest);

	List<GetAllClassroomResponse> getAll();

	GetByIdClassroomResponse getById(int id);
}
