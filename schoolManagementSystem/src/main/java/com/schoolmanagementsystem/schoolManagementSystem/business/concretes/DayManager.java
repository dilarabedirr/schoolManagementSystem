package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.DayService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.dayRequests.CreateDayRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.dayResponses.GetAllDayResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.DayDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Day;

@Service
public class DayManager implements DayService {

	private DayDao dayDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public DayManager(DayDao dayDao, ModelMapperService modelMapperService) {
		this.dayDao = dayDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateDayRequest createDayRequest) {
		Day day = modelMapperService.forRequest().map(createDayRequest, Day.class);
		this.dayDao.save(day);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<GetAllDayResponse>> getAll() {
		List<Day> days = this.dayDao.findAll();
		List<GetAllDayResponse> response = days.stream()
				.map(day -> modelMapperService.forDto().map(day, GetAllDayResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllDayResponse>>(response);
	}

}
