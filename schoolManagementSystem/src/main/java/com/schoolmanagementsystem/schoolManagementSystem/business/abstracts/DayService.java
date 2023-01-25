package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.business.requests.dayRequests.CreateDayRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.dayResponses.GetAllDayResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;

public interface DayService {
	
	Result add(CreateDayRequest createDayRequest);
	
	DataResult<List<GetAllDayResponse>> getAll();

}
