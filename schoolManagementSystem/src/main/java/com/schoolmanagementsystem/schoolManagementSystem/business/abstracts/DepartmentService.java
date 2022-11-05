package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.CreateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.DeleteDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.departmentRequests.UpdateDepartmentRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetAllDepartmentResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.departmentResponses.GetByIdDepartmentResponse;

public interface DepartmentService {

	void add(CreateDepartmentRequest createDepartmentRequest);

	void delete(DeleteDepartmentRequest deleteDepartmentRequest);

	void update(UpdateDepartmentRequest updateDepartmentRequest);

	List<GetAllDepartmentResponse> getAll();

	GetByIdDepartmentResponse getById(int id);
}
