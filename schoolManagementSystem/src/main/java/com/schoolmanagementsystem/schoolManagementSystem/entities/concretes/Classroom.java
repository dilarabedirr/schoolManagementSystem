package com.schoolmanagementsystem.schoolManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "classrooms")
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classroom_id")
	private int classroomId;

	@Column(name = "classroom_name")
	private String classroomName;

	@Column(name = "classroom_capacity")
	private int classroomCapacity;

	@Column(name = "classroom_status")
	private boolean classroomStatus;
}
