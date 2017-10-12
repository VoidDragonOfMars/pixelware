package com.weatherapp.services;

import java.util.List;

import com.weatherapp.model.entities.Report;

public interface ReportService {
	
	List<Report> getAllReportsByIdUser(int idUser);
	int addReport(Report report);
}
