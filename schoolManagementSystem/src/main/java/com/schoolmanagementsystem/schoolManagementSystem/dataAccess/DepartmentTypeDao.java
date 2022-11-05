package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.DepartmentType;
@Repository
public interface DepartmentTypeDao extends JpaRepository<DepartmentType, Integer>{

}
