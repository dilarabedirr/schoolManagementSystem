package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DepartmentTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.DepartmentTypeDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.DepartmentType;

@Service
public class DepartmentTypeManager implements DepartmentTypeService{
	
	private DepartmentTypeDao departmentTypeDao;
	
	@Autowired
	public DepartmentTypeManager(DepartmentTypeDao departmentTypeDao) {
		this.departmentTypeDao  = departmentTypeDao;
	}

	@Override
	public void add(DepartmentType departmentType) {
		departmentTypeDao.save(departmentType);
	}

	@Override
	public List<DepartmentType> getAll() {
		return departmentTypeDao.findAll();
	}

}
