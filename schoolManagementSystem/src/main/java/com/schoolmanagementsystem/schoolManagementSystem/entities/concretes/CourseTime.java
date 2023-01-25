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
@Entity
@Table(name="courseTimes")
@AllArgsConstructor
@NoArgsConstructor
public class CourseTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_time_id")
	private int courseTimeId;
	
	@Column(name="course_time_status")
	private boolean courseTimeStatus;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name="day_id")
	private Day day;
	
	@ManyToOne
	@JoinColumn(name="hour_id")
	private Hour hour;

}
