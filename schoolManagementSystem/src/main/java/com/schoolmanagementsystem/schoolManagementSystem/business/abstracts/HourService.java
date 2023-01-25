package com.schoolmanagementsystem.schoolManagementSystem.business.abstracts;

import java.util.List;

import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.Hour;

public interface HourService {

	Result add(Hour hour);

	DataResult<List<Hour>> getAll();

}
