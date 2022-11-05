package com.schoolmanagementsystem.schoolManagementSystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "instructors")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private int id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "mail")
	private String mail;

	@Column(name = "address")
	private String address;

	@Column(name = "phone")
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="academic_title_id")
	private AcademicTitle academicTitle;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
}
