package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.CreateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.DeleteDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.UpdateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetAllDepartmentResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetByIdDepartmentResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.DepartmentDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao, ModelMapperService modelMapperService) {
		this.departmentDao = departmentDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateDepartmentRequest createDepartmentRequest) {
		Department department = modelMapperService.forRequest().map(createDepartmentRequest, Department.class);
		this.departmentDao.save(department);

	}

	@Override
	public List<GetAllDepartmentResponse> getAll() {
		List<Department> results = this.departmentDao.findAll();
		List<GetAllDepartmentResponse> response = results.stream()
				.map(department -> modelMapperService.forDto().map(department, GetAllDepartmentResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void delete(DeleteDepartmentRequest deleteDepartmentRequest) {
		this.departmentDao.deleteById(deleteDepartmentRequest.getDepartmentId());
	}

	@Override
	public void update(UpdateDepartmentRequest updateDepartmentRequest) {
		Department department = modelMapperService.forRequest().map(updateDepartmentRequest, Department.class);
		this.departmentDao.save(department);
	}

	@Override
	public GetByIdDepartmentResponse getById(int id) {
		Department department = this.departmentDao.findById(id).get();
		GetByIdDepartmentResponse getByIdDepartmentResponse = modelMapperService.forDto().map(department,
				GetByIdDepartmentResponse.class);
		return getByIdDepartmentResponse;
	}

}
