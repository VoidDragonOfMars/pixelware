package com.weatherapp.model.dao;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.weatherapp.exceptions.TwoUserFoundException;
import com.weatherapp.exceptions.UserNotFoundException;
import com.weatherapp.model.entities.User;
import com.weatherapp.services.ReportService;


@Repository
public class UserDaoJdbcImpl  extends JdbcDaoSupport implements UserDaoInterface {

	@Autowired 
	private ReportService reportService;
	
	
	@Autowired
	public UserDaoJdbcImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	


	
	public User getUserByNameAndPass(String name, String pass) {
		
		
		
		String select = "SELECT ID, NAME, EMAIL, DATE, COUNTRY ,PASS FROM users WHERE NAME = ? AND PASS = ?";
		User user = null;
		
		try {
			user = (User) this.getJdbcTemplate().queryForObject(select, new Object[] { name, pass}, new UserRowMapper());
			user.setReports(this.reportService.getAllReportsByIdUser(user.getId()));
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			if(emptyResultDataAccessException.getActualSize() == 0) {
				throw new UserNotFoundException("No se encuentra registrado");
			} 
		} catch ( IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException) {
			throw new TwoUserFoundException("Estos datos ya se encuentran registrados, por favor , cambie el nombre o la contraseña");
		}
		
		
		return user;
	}

	
	public User getUserById(int id) {

		
		String select = "SELECT ID, NAME, EMAIL, DATE, COUNTRY ,PASS FROM USERS WHERE ID = ?";
		User user = (User) this.getJdbcTemplate().queryForObject(select, new Object[] { id }, new UserRowMapper());
		user.setReports(this.reportService.getAllReportsByIdUser(id));
		return user;
	}

	
	public int createUser(User user) {
		String insert = "INSERT INTO USERS VALUES(?,?,?,?,?,?)";
		//GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.getJdbcTemplate().update(insert, new Object[] { user.getId(), user.getName(), user.getEmail(), user.getDate(),
				user.getCountry(), user.getPass() });
		
		return 0;//keyHolder.getKey().intValue();
		
	}

	
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

}
