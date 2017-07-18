package com.caveofprogramming.web.offers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OffersController {
	
	@Autowired
	private IUserDAO userdao;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showLogin(){
		System.out.println("In controller");
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String verifyLogin(@ModelAttribute("user")User user, Model model ){
		String resultString="test";
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
		if(userdao.isValidUser(user)){
			resultString="Succesfully logged in..";
		}
		else{
			resultString="Login Failed";
		}
		model.addAttribute("resultString",resultString);
		return "success";
	}
}
