package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Classroom;

public interface ClassroomDao extends JpaRepository<Classroom, Integer>{

}
