package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.HourService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.HourDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Hour;

@Service
public class HourManager implements HourService {

	private HourDao hourDao;

	@Autowired
	public HourManager(HourDao hourDao) {
		this.hourDao = hourDao;
	}

	@Override
	public Result add(Hour hour) {
		this.hourDao.save(hour);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Hour>> getAll() {
		return new SuccessDataResult<List<Hour>>(this.hourDao.findAll());
	}

}
