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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hours")
public class Hour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hour_id")
	private int id;
	
	@Column(name = "hour")
	private String hour;
	
	@OneToMany(mappedBy="hour")
	List<CourseTime> coursTimes;

}
