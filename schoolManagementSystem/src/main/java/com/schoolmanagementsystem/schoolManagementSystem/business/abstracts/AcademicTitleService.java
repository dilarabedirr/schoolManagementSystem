package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.CreateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.DeleteAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.UpdateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetByIdAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface AcademicTitleService {

	Result add(CreateAcademicTitleRequest createAcademicTitleRequest);

	Result delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest);

	Result update(UpdateAcademicTitleRequest updateAcademicTitleRequest);

	DataResult<List<GetAllAcademicTitleResponse>> getAll();

	DataResult<GetByIdAcademicTitleResponse> getById(int id);

}
