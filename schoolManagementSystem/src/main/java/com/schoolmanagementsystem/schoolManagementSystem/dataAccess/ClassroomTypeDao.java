package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.ClassroomType;

public interface ClassroomTypeDao extends JpaRepository<ClassroomType, Integer>{

}
