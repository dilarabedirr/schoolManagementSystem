package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.InstructorService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.CreateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.DeleteInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.instructorRequests.UpdateInstructorRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetByIdDepartmentResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetAllInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.instructorResponses.GetByIdInstructorResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.InstructorDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Department;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Instructor;

@Service
public class InstructorManager implements InstructorService {

	private InstructorDao instructorDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public InstructorManager(InstructorDao instructorDao, ModelMapperService modelMapperService) {
		this.instructorDao = instructorDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateInstructorRequest createInstructorRequest) {
		Instructor instructor = this.modelMapperService.forRequest().map(createInstructorRequest, Instructor.class);
		this.instructorDao.save(instructor);
	}

	@Override
	public void delete(DeleteInstructorRequest deleteInstructorRequest) {
		this.instructorDao.deleteById(deleteInstructorRequest.getId());

	}

	@Override
	public void update(UpdateInstructorRequest updateInstructorRequest) {
		Instructor instructor = this.modelMapperService.forRequest().map(updateInstructorRequest, Instructor.class);
		this.instructorDao.save(instructor);

	}

	@Override
	public List<GetAllInstructorResponse> getAll() {
		List<Instructor> instructors = this.instructorDao.findAll();
		List<GetAllInstructorResponse> response = instructors.stream()
				.map(instructor -> modelMapperService.forDto().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public GetByIdInstructorResponse getById(int id) {
		Instructor instructor = this.instructorDao.findById(id).get();
		GetByIdInstructorResponse response = modelMapperService.forDto().map(instructor,
				GetByIdInstructorResponse.class);
		return response;
	}

}
