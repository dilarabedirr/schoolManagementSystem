package com.schoolmanagementsystem.schoolManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id")
	private int departmentId;

	@Column(name = "department_name")
	private String departmentName;
	
	@ManyToOne
	@JoinColumn(name="department_type_id")
	private DepartmentType departmentType;
	
	@OneToMany(mappedBy= "department")
	List<Classroom> classrooms;
	
	@OneToMany(mappedBy="department")
	List<Instructor> instructors;
	
	@OneToMany(mappedBy="department")
	List<CourseTime> courseTimes;

}
