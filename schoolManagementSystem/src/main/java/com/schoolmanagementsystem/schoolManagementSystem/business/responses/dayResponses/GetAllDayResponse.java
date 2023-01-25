package com.schoolmanagementsystem.schoolManagementSystem.business.responses.dayResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDayResponse {
	private int id;
	private String day;
}
