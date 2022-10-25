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
@Table(name = "departmentTypes")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_type_id")
	private int departmentTypeId;

	@Column(name = "department_type_description")
	private String departmentTypeDescription;

}
