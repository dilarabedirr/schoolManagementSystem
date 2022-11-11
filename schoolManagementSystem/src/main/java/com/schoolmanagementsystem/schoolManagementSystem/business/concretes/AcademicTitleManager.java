package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.AcademicTitleService;
import com.schoolmanagementsystem.schoolManagementSystem.business.constants.Messages;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.CreateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.DeleteAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.UpdateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetByIdAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.business.BusinessRules;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.DataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.ErrorResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.Result;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessDataResult;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.SuccessResult;
import com.schoolmanagementsystem.schoolManagementSystem.dataAccess.AcademicTitleDao;
import com.schoolmanagementsystem.schoolManagementSystem.entities.concretes.AcademicTitle;

@Service
public class AcademicTitleManager implements AcademicTitleService {

	private AcademicTitleDao academicTitleDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public AcademicTitleManager(AcademicTitleDao academicTitleDao, ModelMapperService modelMapperService) {
		this.academicTitleDao = academicTitleDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result add(CreateAcademicTitleRequest createAcademicTitleRequest) {
		Result result = BusinessRules.run(checkIfAcademicTitleExists(createAcademicTitleRequest.getAcademicTitle()));
		if (result != null) {
			return result;
		}
		AcademicTitle academicTitle = modelMapperService.forRequest().map(createAcademicTitleRequest,
				AcademicTitle.class);
		this.academicTitleDao.save(academicTitle);
		return new SuccessResult(Messages.ACADEMIC_TITLE_ADDED);
	}

	@Override
	public Result update(UpdateAcademicTitleRequest updateAcademicTitleRequest) {
		AcademicTitle academicTitle = modelMapperService.forRequest().map(updateAcademicTitleRequest,
				AcademicTitle.class);
		this.academicTitleDao.save(academicTitle);
		return new SuccessResult(Messages.ACADEMIC_TITLE_UPDATED);
	}

	@Override
	public Result delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest) {
		this.academicTitleDao.deleteById(deleteAcademicTitleRequest.getAcademicTitleId());
		return new SuccessResult(Messages.ACADEMIC_TITLE_DELETED);
	}

	@Override
	public DataResult<List<GetAllAcademicTitleResponse>> getAll() {
		List<AcademicTitle> academicTitles = this.academicTitleDao.findAll();
		List<GetAllAcademicTitleResponse> response = academicTitles.stream()
				.map(academicTitle -> modelMapperService.forDto().map(academicTitle, GetAllAcademicTitleResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllAcademicTitleResponse>>(response, Messages.ACADEMIC_TITLE_GETALL);
	}

	@Override
	public DataResult<GetByIdAcademicTitleResponse> getById(int id) {
		AcademicTitle academicTitle = this.academicTitleDao.findById(id).get();
		GetByIdAcademicTitleResponse response = modelMapperService.forDto().map(academicTitle,
				GetByIdAcademicTitleResponse.class);
		return new SuccessDataResult<GetByIdAcademicTitleResponse>(response, Messages.ACADEMIC_TITLE_GETBYID);
	}

	private Result checkIfAcademicTitleExists(String name) {
		var academicTitles = this.academicTitleDao.findAll();
		for (AcademicTitle academicTitle : academicTitles) {
			if (academicTitle.getAcademicTitle().equalsIgnoreCase(name)) {
				return new ErrorResult(Messages.ACADEMIC_TITLE_EXISTS);
			}
		}
		return new SuccessResult();
	}

}
