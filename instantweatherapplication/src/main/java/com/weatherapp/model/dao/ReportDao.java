package com.weatherapp.model.dao;


import java.util.List;

import com.weatherapp.model.entities.Report;

public interface ReportDao {
	
	
	List<Report> getAllbyIdUser(int idUser) ;
	int addReport(Report report);
}
