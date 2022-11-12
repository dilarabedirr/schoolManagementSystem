package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.CreateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.DeleteClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.UpdateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetAllClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetByIdClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface ClassroomTypeService {
	
	Result add(CreateClassroomTypeRequest classroomTypeRequest);
	
	Result delete(DeleteClassroomTypeRequest deleteClassroomTypeRequest);
	
	Result update(UpdateClassroomTypeRequest updateClassroomTypeRequest);

	DataResult<List<GetAllClassroomTypeResponse>> getAll();
	
	DataResult<GetByIdClassroomTypeResponse> getById(int id);
}
