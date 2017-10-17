package com.springhibernate.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.springhibernate.java.model.User;
import com.springhibernate.java.service.UserService;

@Controller
public class PersonController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loadIndex(Model model) {
		System.out.println("In Controller");
		userService.printAll();
		return "login";
	}

/*	@ResponseBody
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();
		//logic
		return result;

	}
*/
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, Model model) {
		System.out.println("Login Request from : " + user.getUsername());
		try {
			User userfromDb = userService.getUserById(user.getUsername());  
			if (user.getPassword().equalsIgnoreCase(userfromDb.getPassword())) {
				return "index";
			} else {
				model.addAttribute("loginError", "No User Found, Please Try Again");
				return "login";
			}
		} catch (Exception ex) {

			model.addAttribute("loginError", "No User Found, Please Try Again: " + ex.getLocalizedMessage());
			return "login";

		}
	}

	@RequestMapping(value = "/signupPage", method = RequestMethod.GET)
	public String loadSignup(Model model) {
		System.out.println("In Controller");
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupUser(@ModelAttribute("user") User user, Model model) {
		System.out.println("Signup Request from : " + user.getEmail());
		try {
			if(userService.checkIfUserNameExists(user.getUsername())){
				model.addAttribute("loginError", "UserName is Used Already");
				return "signup";
			}
			else{
				userService.addUser(user);
				return "index";
			}
		} catch (Exception ex) {
			model.addAttribute("loginError", ex.getLocalizedMessage());
			return "signup";
		}
	}
}
