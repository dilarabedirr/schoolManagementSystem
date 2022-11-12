package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.CreateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.DeleteClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.UpdateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetAllClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetByIdClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface ClassroomService {
	Result add(CreateClassroomRequest createClassroomRequest);

	Result delete(DeleteClassroomRequest deleteClassroomRequest);

	Result update(UpdateClassroomRequest updateClassroomRequest);

	DataResult<List<GetAllClassroomResponse>> getAll();

	DataResult<GetByIdClassroomResponse> getById(int id);
}
