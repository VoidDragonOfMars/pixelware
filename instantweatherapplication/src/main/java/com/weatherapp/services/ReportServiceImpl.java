package com.weatherapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapp.model.dao.ReportDao;
import com.weatherapp.model.entities.Report;


@Service("reportService")
public class ReportServiceImpl implements ReportService{

	@Autowired
	private ReportDao reportDao;
	
	@Override
	public List<Report> getAllReportsByIdUser(int idUser) {
		
		
		return reportDao.getAllbyIdUser(idUser);
	}

	@Override
	public int addReport(Report report) {
		
		return reportDao.addReport(report);
	}

}
