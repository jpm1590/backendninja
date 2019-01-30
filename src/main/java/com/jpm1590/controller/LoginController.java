package com.jpm1590.controller;

import com.jpm1590.model.UserCredential;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private static final Log LOG = LogFactory.getLog(LoginController.class); 
	
	@GetMapping("/")
	public String redirectToLogin() {
		
		LOG.info("METHOD: redirectToLogin");
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout) {

		LOG.info("METHOD: showLoginForm");
		model.addAttribute("userCredentials",new UserCredential());
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String loginChecK(@ModelAttribute(name="userCredentials") UserCredential userCredential) {
		
		LOG.info("METHOD: loginChecK");
		if(userCredential.getUsername().equals("user") && userCredential.getPassword().equals("user")) {
			return "contacts";			
		}
		
		return "redirect:/login?error";
	}
	
}
