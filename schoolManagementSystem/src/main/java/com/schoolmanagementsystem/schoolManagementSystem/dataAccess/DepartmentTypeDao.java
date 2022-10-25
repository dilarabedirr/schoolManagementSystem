package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.DepartmentType;

public interface DepartmentTypeDao extends JpaRepository<DepartmentType, Integer>{

}
