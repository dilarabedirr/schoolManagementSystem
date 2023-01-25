package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.courseTimeRequests.CreateCourseTimeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.courseTimeResponses.GetAllCourseTimeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface CourseTimeService {

	Result add(CreateCourseTimeRequest createCourseTimeRequest);

	DataResult<List<GetAllCourseTimeResponse>> getAll();

}
