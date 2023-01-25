package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.CourseTime;

public interface CourseTimeDao extends JpaRepository<CourseTime, Integer> {

}
