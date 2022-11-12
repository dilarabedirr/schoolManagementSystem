package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.CreateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.DeleteInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.UpdateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetAllInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetByIdInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface InstructorService {

	Result add(CreateInstructorRequest createInstructorRequest);

	Result delete(DeleteInstructorRequest deleteInstructorRequest);

	Result update(UpdateInstructorRequest updateInstructorRequest);

	DataResult<List<GetAllInstructorResponse>> getAll();

	DataResult<GetByIdInstructorResponse> getById(int id);

}
