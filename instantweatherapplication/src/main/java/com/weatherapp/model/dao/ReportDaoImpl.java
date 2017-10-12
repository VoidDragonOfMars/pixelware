package com.weatherapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.weatherapp.model.entities.Report;


@Repository
public class ReportDaoImpl extends JdbcDaoSupport implements ReportDao {

	
	@Autowired
	
	public ReportDaoImpl(DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	
	
	@Override
	public List<Report> getAllbyIdUser(int idUser) {
		String sql = "SELECT ID, ID_USER, CITY, TEMPERATURE FROM REPORTS WHERE ID_USER = " + idUser + " ORDER BY id DESC LIMIT 10;";
		
		
		List<Report> reports = new ArrayList<>();
		List<Map<String,Object>>rows = this.getJdbcTemplate().queryForList(sql);
		
		for(Map<String, Object> row : rows){
			Report report = new Report(
					(int)row.get("ID_USER"), 
					(String)row.get("CITY"), 
					(double)row.get("TEMPERATURE"));
			reports.add(report);				
		}
		
		
		return reports;
	}



	@Override
	public int addReport(Report report) {
		String insert = "INSERT INTO REPORTS VALUES (?,?,?,?)";
		
		return this.getJdbcTemplate().update(insert, new Object[]{null,report.getId_user(), report.getCity(), report.getTemperature()});

	}

}
