package com.schoolmanagementsystem.schoolManagementSystem.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "classroomTypes")
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classroom_type_id")
	private int id;

	@Column(name = "classroom_type_description")
	private String classroomTypeDescription;

	@OneToMany(mappedBy = "classroomType")
	List<Classroom> classrooms;

}
