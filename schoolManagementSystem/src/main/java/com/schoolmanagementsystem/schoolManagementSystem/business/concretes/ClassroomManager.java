package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.CreateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.DeleteClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.classroomRequests.UpdateClassroomRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetAllClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.classroomResponses.GetByIdClassroomResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
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
	public void add(CreateClassroomRequest createClassroomRequest) {
		Classroom classroom = modelMapperService.forRequest().map(createClassroomRequest, Classroom.class);
		this.classroomDao.save(classroom);

	}

	@Override
	public List<GetAllClassroomResponse> getAll() {
		List<Classroom> results = this.classroomDao.findAll();
		List<GetAllClassroomResponse> response = results.stream()
				.map(classroom -> modelMapperService.forDto().map(classroom, GetAllClassroomResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void delete(DeleteClassroomRequest deleteClassroomRequest) {
		this.classroomDao.deleteById(deleteClassroomRequest.getClassroomId());
	}

	@Override
	public void update(UpdateClassroomRequest updateClassroomRequest) {
		Classroom classroom = modelMapperService.forRequest().map(updateClassroomRequest, Classroom.class);
		this.classroomDao.save(classroom);
	}

	@Override
	public GetByIdClassroomResponse getById(int id) {
		Classroom classroom = this.classroomDao.findById(id).get();
		GetByIdClassroomResponse getByIdClassroomResponse = modelMapperService.forDto().map(classroom,
				GetByIdClassroomResponse.class);
		return getByIdClassroomResponse;
	}

}
