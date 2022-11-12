package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomService;
import com.schoolmanagementsystem.schoolManagementSystem.business.constants.Messages;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.CreateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.DeleteClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.UpdateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetAllClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetByIdClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.ClassroomDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Classroom;

@Service
public class ClassroomManager implements ClassroomService {

	private ClassroomDao classroomDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ClassroomManager(ClassroomDao classroomDao, ModelMapperService modelMapperService) {
		this.classroomDao = classroomDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateClassroomRequest createClassroomRequest) {
		Classroom classroom = modelMapperService.forRequest().map(createClassroomRequest, Classroom.class);
		this.classroomDao.save(classroom);
		return new SuccessResult(Messages.CLASSROOM_ADDED);

	}

	@Override
	public DataResult<List<GetAllClassroomResponse>> getAll() {
		List<Classroom> results = this.classroomDao.findAll();
		List<GetAllClassroomResponse> response = results.stream()
				.map(classroom -> modelMapperService.forDto().map(classroom, GetAllClassroomResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllClassroomResponse>>(response, Messages.CLASSROOM_GETALL);
	}

	@Override
	public Result delete(DeleteClassroomRequest deleteClassroomRequest) {
		this.classroomDao.deleteById(deleteClassroomRequest.getClassroomId());
		return new SuccessResult(Messages.CLASSROOM_DELETED);
	}

	@Override
	public Result update(UpdateClassroomRequest updateClassroomRequest) {
		Classroom classroom = modelMapperService.forRequest().map(updateClassroomRequest, Classroom.class);
		this.classroomDao.save(classroom);
		return new SuccessResult(Messages.CLASSROOM_UPDATED);
	}

	@Override
	public DataResult<GetByIdClassroomResponse> getById(int id) {
		Classroom classroom = this.classroomDao.findById(id).get();
		GetByIdClassroomResponse getByIdClassroomResponse = modelMapperService.forDto().map(classroom,
				GetByIdClassroomResponse.class);
		return new SuccessDataResult<GetByIdClassroomResponse>(getByIdClassroomResponse, Messages.CLASSROOM_GETBYID);
	}

}
