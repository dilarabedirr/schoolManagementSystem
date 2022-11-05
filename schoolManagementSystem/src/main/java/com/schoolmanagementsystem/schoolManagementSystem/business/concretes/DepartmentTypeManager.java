package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.CreateDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.DeleteDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentTypeRequests.UpdateDepartmentTypeRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses.GetAllDepartmentTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentTypeResponses.GetByIdDepartmentTypeResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.DepartmentTypeDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.DepartmentType;

@Service
public class DepartmentTypeManager implements DepartmentTypeService {

	private DepartmentTypeDao departmentTypeDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public DepartmentTypeManager(DepartmentTypeDao departmentTypeDao, ModelMapperService modelMapperService) {
		this.departmentTypeDao = departmentTypeDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateDepartmentTypeRequest createDepartmentTypeRequest) {
		DepartmentType departmentType = modelMapperService.forRequest().map(createDepartmentTypeRequest,
				DepartmentType.class);
		this.departmentTypeDao.save(departmentType);

	}

	@Override
	public List<GetAllDepartmentTypeResponse> getAll() {
		List<DepartmentType> results = this.departmentTypeDao.findAll();
		List<GetAllDepartmentTypeResponse> response = results.stream().map(
				departmentType -> modelMapperService.forDto().map(departmentType, GetAllDepartmentTypeResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public void delete(DeleteDepartmentTypeRequest deleteDepartmentTypeRequest) {
		this.departmentTypeDao.deleteById(deleteDepartmentTypeRequest.getDepartmentTypeId());
	}

	@Override
	public void update(UpdateDepartmentTypeRequest updateDepartmentTypeRequest) {
		DepartmentType departmentType = modelMapperService.forRequest().map(updateDepartmentTypeRequest,
				DepartmentType.class);
		this.departmentTypeDao.save(departmentType);
	}

	@Override
	public GetByIdDepartmentTypeResponse getById(int id) {
		DepartmentType departmentType = this.departmentTypeDao.findById(id).get();
		GetByIdDepartmentTypeResponse getByIdDepartmentTypeResponse = modelMapperService.forDto().map(departmentType,
				GetByIdDepartmentTypeResponse.class);
		return getByIdDepartmentTypeResponse;
	}

}
