package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomTypeService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.ClassroomTypeDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.ClassroomType;

@Service
public class ClassroomTypeManager implements ClassroomTypeService{
	
	private ClassroomTypeDao classroomTypeDao;
	
	@Autowired
	public ClassroomTypeManager(ClassroomTypeDao classroomTypeDao) {
		this.classroomTypeDao = classroomTypeDao;
	}

	@Override
	public void add(ClassroomType classroomType) {
		classroomTypeDao.save(classroomType);
	}

	@Override
	public List<ClassroomType> getAll() {
		return classroomTypeDao.findAll();
	}

}
