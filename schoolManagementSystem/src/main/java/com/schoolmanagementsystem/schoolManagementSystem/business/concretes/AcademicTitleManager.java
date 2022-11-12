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
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.results.ErrorDataResult;
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
		Result result = BusinessRules.run(checkIfAcademicTitleExists(createAcademicTitleRequest.getAcademicTitle()),
				checkIfShortNameExists(createAcademicTitleRequest.getShortName()));
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
		Result result = BusinessRules.run(checkIfAcademicTitleExistsForUpdate(updateAcademicTitleRequest),checkIfAcademicTitleIdExists(updateAcademicTitleRequest.getAcademicTitleId()),
				checkIfAcademicTitleIdValid(updateAcademicTitleRequest.getAcademicTitleId()));
		if (result != null) {
			return result;
		}
		AcademicTitle academicTitle = modelMapperService.forRequest().map(updateAcademicTitleRequest,
				AcademicTitle.class);
		this.academicTitleDao.save(academicTitle);
		return new SuccessResult(Messages.ACADEMIC_TITLE_UPDATED);
	}

	@Override
	public Result delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest) {
		Result result = BusinessRules.run(checkIfAcademicTitleIdExists(deleteAcademicTitleRequest.getAcademicTitleId()),
				checkIfAcademicTitleIdValid(deleteAcademicTitleRequest.getAcademicTitleId()));
		if (result != null) {
			return result;
		}
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
		Result result = BusinessRules.run(checkIfAcademicTitleIdExists(id), checkIfAcademicTitleIdValid(id));
		if (result != null) {
			return new ErrorDataResult(result);
		}
		AcademicTitle academicTitle = this.academicTitleDao.findById(id).get();
		GetByIdAcademicTitleResponse response = modelMapperService.forDto().map(academicTitle,
				GetByIdAcademicTitleResponse.class);
		return new SuccessDataResult<GetByIdAcademicTitleResponse>(response, Messages.ACADEMIC_TITLE_GETBYID);
	}

	private Result checkIfAcademicTitleExists(String name) {
		AcademicTitle academicTitle = this.academicTitleDao.getByAcademicTitle(name);
		if (academicTitle != null) {
			return new ErrorResult(Messages.ACADEMIC_TITLE_EXISTS);
		}
		return new SuccessResult();
	}

	private Result checkIfShortNameExists(String shortName) {
		AcademicTitle academicTitle = this.academicTitleDao.getByShortName(shortName);
		if (academicTitle != null) {
			return new ErrorResult(Messages.ACADEMIC_TITLE_SHORT_NAME_EXISTS);
		}
		return new SuccessResult();
	}

	private Result checkIfAcademicTitleIdExists(int id) {
		if (!this.academicTitleDao.existsById(id) && id>0) {
			return new ErrorResult(Messages.ACADEMIC_TITLE_NOT_FOUND);
		}
		return new SuccessResult();
	}

	private Result checkIfAcademicTitleIdValid(int id) {
		if (id <= 0) {
			return new ErrorResult(Messages.ACADEMIC_TITLE_ID_IS_NOT_VALID);
		}
		return new SuccessResult();
	}

	private Result checkIfAcademicTitleExistsForUpdate(UpdateAcademicTitleRequest updateAcademicTitleRequest) {
		List<AcademicTitle> academicTitles = this.academicTitleDao.findAll();
		for (AcademicTitle academicTitle : academicTitles) {
			if (academicTitle.getAcademicTitle().equals(updateAcademicTitleRequest.getAcademicTitle()) 
					&& academicTitle.getShortName().equals(updateAcademicTitleRequest.getShortName()) ) {
				return new ErrorResult(Messages.ACADEMIC_TITLE_EXISTS);
			}
		}
		return new SuccessResult();
	}

}
