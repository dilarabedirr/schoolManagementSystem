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

@Table(name = "academictitles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AcademicTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "academic_title_id")
	private int id;

	@Column(name = "academic_title")
	private String academicTitle;

	@Column(name = "short_name")
	private String shortName;
	
	@OneToMany(mappedBy ="academicTitle")
	List<Instructor> instructors;

}
