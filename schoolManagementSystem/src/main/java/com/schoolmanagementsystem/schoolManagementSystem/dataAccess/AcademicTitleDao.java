package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.AcademicTitle;

@Repository
public interface AcademicTitleDao extends JpaRepository<AcademicTitle, Integer> {
	
	AcademicTitle getByAcademicTitle(String academicTitle);

	AcademicTitle getByShortName(String shortName);
	
	boolean existsById(int id);

}
