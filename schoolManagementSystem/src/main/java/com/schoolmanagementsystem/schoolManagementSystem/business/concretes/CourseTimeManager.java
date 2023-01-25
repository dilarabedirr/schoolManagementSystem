package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.CourseTimeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.constants.Messages;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.courseTimeRequests.CreateCourseTimeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.courseTimeResponses.GetAllCourseTimeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.CourseTimeDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.AcademicTitle;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.CourseTime;

@Service
public class CourseTimeManager implements CourseTimeService {

	private CourseTimeDao courseTimeDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public CourseTimeManager(CourseTimeDao courseTimeDao, ModelMapperService modelMapperService) {
		this.courseTimeDao = courseTimeDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateCourseTimeRequest createCourseTimeRequest) {
		CourseTime courseTime = modelMapperService.forRequest().map(createCourseTimeRequest, CourseTime.class);
		this.courseTimeDao.save(courseTime);
		return new SuccessResult(Messages.COURSE_TIME_ADDED);
	}

	@Override
	public DataResult<List<GetAllCourseTimeResponse>> getAll() {
		List<CourseTime> coursesTime = this.courseTimeDao.findAll();
		List<GetAllCourseTimeResponse> response = coursesTime.stream()
				.map(courseTime -> modelMapperService.forDto().map(courseTime, GetAllCourseTimeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCourseTimeResponse>>(response, Messages.COURSE_TIME_GETALL);
	}

}
