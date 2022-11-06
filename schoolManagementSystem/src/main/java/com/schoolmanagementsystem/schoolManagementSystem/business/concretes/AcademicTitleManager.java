package com.schoolmanagementsystem.schoolManagementSystem.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmanagementsystem.schoolManagementSystem.business.abstracts.AcademicTitleService;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.CreateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.DeleteAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.requests.academicTitleRequests.UpdateAcademicTitleRequest;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetAllAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.business.responses.academicTitleResponses.GetByIdAcademicTitleResponse;
import com.schoolmanagementsystem.schoolManagementSystem.core.utilities.mapping.ModelMapperService;
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
	public void add(CreateAcademicTitleRequest createAcademicTitleRequest) {
		AcademicTitle academicTitle = modelMapperService.forRequest().map(createAcademicTitleRequest,
				AcademicTitle.class);
		this.academicTitleDao.save(academicTitle);
	}

	@Override
	public void update(UpdateAcademicTitleRequest updateAcademicTitleRequest) {
		AcademicTitle academicTitle = modelMapperService.forRequest().map(updateAcademicTitleRequest,
				AcademicTitle.class);
		this.academicTitleDao.save(academicTitle);

	}

	@Override
	public void delete(DeleteAcademicTitleRequest deleteAcademicTitleRequest) {
		this.academicTitleDao.deleteById(deleteAcademicTitleRequest.getAcademicTitleId());
	}

	@Override
	public List<GetAllAcademicTitleResponse> getAll() {
		List<AcademicTitle> academicTitles = this.academicTitleDao.findAll();
		List<GetAllAcademicTitleResponse> response = academicTitles.stream()
				.map(academicTitle -> modelMapperService.forDto().map(academicTitle, GetAllAcademicTitleResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public GetByIdAcademicTitleResponse getById(int id) {
		AcademicTitle academicTitle = this.academicTitleDao.findById(id).get();
		GetByIdAcademicTitleResponse response = modelMapperService.forDto().map(academicTitle,
				GetByIdAcademicTitleResponse.class);
		return response;
	}

}
