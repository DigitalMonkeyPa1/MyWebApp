package com.project1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController
{
	@RequestMapping("/login")
	public String getLoginPage(@RequestParam(required=false) String error, @RequestParam(required=false) String logout, Model model)
	{
		if(error != null)
		{
			model.addAttribute("errorAttribute", "Invalid username or password!");
		}
		
		if(logout != null)
		{
			model.addAttribute("logoutMsgAttribute", "Logged out successfully");
		}
		return "login";
	}
}
