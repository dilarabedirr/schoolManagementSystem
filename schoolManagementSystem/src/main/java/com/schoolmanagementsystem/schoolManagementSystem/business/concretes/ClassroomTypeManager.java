package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.constants.Messages;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.CreateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.DeleteClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomTypeRequests.UpdateClassroomTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetAllClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomTypeResponses.GetByIdClassroomTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.ClassroomTypeDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.ClassroomType;

@Service
public class ClassroomTypeManager implements ClassroomTypeService {

	private ClassroomTypeDao classroomTypeDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public ClassroomTypeManager(ClassroomTypeDao classroomTypeDao, ModelMapperService modelMapperService) {
		this.classroomTypeDao = classroomTypeDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateClassroomTypeRequest createClassroomTypeRequest) {
		ClassroomType classroomType = modelMapperService.forRequest().map(createClassroomTypeRequest,
				ClassroomType.class);
		this.classroomTypeDao.save(classroomType);
		return new SuccessResult(Messages.CLASSROOM_TYPE_ADDED);
	}

	@Override
	public DataResult<List<GetAllClassroomTypeResponse>> getAll() {
		List<ClassroomType> results = this.classroomTypeDao.findAll();
		List<GetAllClassroomTypeResponse> response = results.stream()
				.map(classroomType -> modelMapperService.forDto().map(classroomType, GetAllClassroomTypeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllClassroomTypeResponse>>(response, Messages.CLASSROOM_TYPE_GETALL) ;
	}

	@Override
	public Result delete(DeleteClassroomTypeRequest deleteClassroomTypeRequest) {
		this.classroomTypeDao.deleteById(deleteClassroomTypeRequest.getClassroomTypeId());
		return new SuccessResult(Messages.CLASSROOM_TYPE_DELETED);

	}

	@Override
	public Result update(UpdateClassroomTypeRequest updateClassroomTypeRequest) {
		ClassroomType classroomType = modelMapperService.forRequest().map(updateClassroomTypeRequest,
				ClassroomType.class);
		this.classroomTypeDao.save(classroomType);
		return new SuccessResult(Messages.CLASSROOM_TYPE_UPDATED);
	}

	@Override
	public DataResult<GetByIdClassroomTypeResponse> getById(int id) {
		ClassroomType classroomType = this.classroomTypeDao.findById(id).get();
		GetByIdClassroomTypeResponse getByIdClassroomTypeResponse = modelMapperService.forDto().map(classroomType,
				GetByIdClassroomTypeResponse.class);
		return new SuccessDataResult<GetByIdClassroomTypeResponse>(getByIdClassroomTypeResponse, Messages.CLASSROOM_TYPE_GETBYID) ;
	}

}
