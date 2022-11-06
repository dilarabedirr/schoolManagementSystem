package com.schoolmanagementsystem.schoolManagementSystem.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Instructor;

public interface InstructorDao extends JpaRepository<Instructor, Integer> {

}
