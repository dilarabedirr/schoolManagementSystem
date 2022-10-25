package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.ClassroomService;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.ClassroomDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Classroom;

@Service
public class ClassroomManager implements ClassroomService {

	private ClassroomDao classroomDao;

	@Autowired
	public ClassroomManager(ClassroomDao classroomDao) {
		this.classroomDao = classroomDao;
	}

	@Override
	public void add(Classroom classroom) {
		classroomDao.save(classroom);
	}

	@Override
	public List<Classroom> getAll() {
		return classroomDao.findAll();
	}

}
