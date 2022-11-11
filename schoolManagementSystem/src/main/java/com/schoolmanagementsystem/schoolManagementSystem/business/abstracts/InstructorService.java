package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.CreateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.DeleteInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.UpdateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetAllInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetByIdInstructorResponse;

public interface InstructorService {

	void add(CreateInstructorRequest createInstructorRequest);

	void delete(DeleteInstructorRequest deleteInstructorRequest);

	void update(UpdateInstructorRequest updateInstructorRequest);

	List<GetAllInstructorResponse> getAll();

	GetByIdInstructorResponse getById(int id);

}
