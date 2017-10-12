package com.weatherapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.weatherapp.exceptions.TwoUserFoundException;
import com.weatherapp.exceptions.UserNotFoundException;
import com.weatherapp.model.entities.Report;
import com.weatherapp.model.entities.User;
import com.weatherapp.services.ReportService;
import com.weatherapp.services.UserService;
import com.weatherapp.validators.UserLoginValidator;
import com.weatherapp.validators.UserRegisterValidator;

@Controller

@SessionAttributes("userLogin")
public class LoginController {
	
	
	@Autowired
	private UserService userService;

	@Autowired
	private ReportService reportService;
	
	
	@Autowired
	private UserLoginValidator userLoginValidator;
	
	@Autowired
	private UserRegisterValidator userRegisterValidator;
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession(true);
		
		if(session == null){
			model.addAttribute("user", new User());
			return "index";
			
		}
		
		
		
		if((session.getAttribute("userLogin") != null)){
			
			
			model.addAttribute("report", new Report());
			return "reports";
		}

		
		model.addAttribute("user", new User());
		
		return "index";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			if(!(session.getAttribute("userLogin") != null)){
				session.setAttribute("userLogin", null);
			}
			
			
			
		}
		
		
		
		
		model.addAttribute("user", new User());
		
		return "index";
		
	}
	
	@InitBinder("user")
	protected void initUserLoginBinder(WebDataBinder binder) {
		binder.addValidators(userLoginValidator);
	}
	
	

	
	@InitBinder("newUser")
	protected void initUserRegisterBinder(WebDataBinder binder) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	 	simpleDateFormat.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, true));
		
		
		binder.addValidators(userRegisterValidator);
	}
	
	
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@ModelAttribute("user") @Validated User user, BindingResult result, Model model, HttpServletRequest request) {


		if(result.hasErrors()) {
			
			return "index";
		}
		
		User userLogin = userService.getUserByNameAndPass(user.getName(), user.getPass());
		userLogin.setReports(this.reportService.getAllReportsByIdUser(userLogin.getId()));
		
		model.addAttribute("userLogin", userLogin);
		
		
		
		model.addAttribute("report", new Report());
		return "reports";

		
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute("newUser") @Validated User newUser, BindingResult result,HttpServletRequest request, Model model) {
		
		if(result.hasErrors()) {
			
			return "register";
		}
		
		
		
		

		
		userService.createUser(newUser);
		User userLogin = userService.getUserByNameAndPass(newUser.getName(), newUser.getPass());
		
		userLogin.setReports(reportService.getAllReportsByIdUser(userLogin.getId()));
		
		HttpSession session = request.getSession(true);
		session.setAttribute("userLogin", userLogin);
		return "successRegister";
	}
	
	@RequestMapping("/registerUser")
	public String registerUser(Model model) {
		model.addAttribute("newUser", new User());
		return "register";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView managedError(UserNotFoundException userException, Model model) {
		ModelAndView modelAndView = new ModelAndView("index");
		
		modelAndView.addObject("user", new User());
		modelAndView.addObject("error", userException.getMessage());
		return modelAndView;
	}
	
	
	
	
	@ExceptionHandler(TwoUserFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView managedErrorTwoUsers(TwoUserFoundException twoUserFoundException, Model model) {
		ModelAndView modelAndView = new ModelAndView("register");
		
		modelAndView.addObject("newUser", new User());
		modelAndView.addObject("error", twoUserFoundException.getMessage());
		return modelAndView;
	}
	
	
	
	
	

}
