package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.CreateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.DeleteAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.UpdateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetByIdAcademicTitleResponse;

public interface AcademicTitleService {

	void add(CreateAcademicTitleRequest createAcademicTitleRequest);

	void delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest);

	void update(UpdateAcademicTitleRequest updateAcademicTitleRequest);

	List<GetAllAcademicTitleResponse> getAll();

	GetByIdAcademicTitleResponse getById(int id);

}
