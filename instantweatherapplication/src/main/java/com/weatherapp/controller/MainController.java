package com.weatherapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.weatherapp.exceptions.WeatherServiceErrorException;
import com.weatherapp.model.entities.Report;
import com.weatherapp.model.entities.User;
import com.weatherapp.services.ReportService;
import com.weatherapp.services.WeatherService;
import com.weatherapp.validators.ReportFormValidator;




@Controller

public class MainController {
	
	
	@Autowired
	
	private WeatherService weatherService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ReportFormValidator reportFormValidator;
	
	@InitBinder("report")
	protected void initReportFormBinder(WebDataBinder binder) {
		binder.addValidators(reportFormValidator);
	}
	
	
	@ModelAttribute("report")
	public Report loadReport() {
		return new Report();
	}
	
	
	
	
	@RequestMapping("/reports")
	public String index(@SessionAttribute("userLogin") User user, Model model) {
		
		if(user == null) {
			return "index";
		}

		return "reports";
	}
	
	
	@RequestMapping(value="/getReport", method=RequestMethod.POST)
	public String getReport(@SessionAttribute("userLogin") User user, @ModelAttribute("report") @Validated Report report, BindingResult result, Model model ) {
		
		if(result.hasErrors()) {
			
			return "reports";
		}

		report.setId_user(user.getId());
		
		report.setTemperature(this.weatherService.getCurrentWeather(report.getCity()).getCurrent().getTemp_c());
		
		reportService.addReport(report);
		user.setReports(reportService.getAllReportsByIdUser(user.getId()));
		String mensaje = "The temperature in " + report.getCity() +  " is " + report.getTemperature() + "ºC";
		model.addAttribute("mensaje", mensaje);
		return "reports";
	}
	
	
	@ExceptionHandler(WeatherServiceErrorException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView managedError(WeatherServiceErrorException weatherServiceErrorException, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("reports");
		
		modelAndView.addObject("report", new Report());
		modelAndView.addObject("error", weatherServiceErrorException.getMessage());
		return modelAndView;
		
		
		
		
		
	}
	
	
	
	
}
