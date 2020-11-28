package com.example.groupproject.auth;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "http://localhost:3000/**")
public class HomeController {
	
	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
	}
	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private MySQLUserDetailsService userService;
	
    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    @GetMapping("/secure")
    public String getSecurePage() {
        return "secure";
    }

    @GetMapping("/login")
    public User getLoginPage(@RequestParam("username") String username, @RequestParam("password") String password) {
    	User foundUser = userRepository.findByUsername(username);
    	if (foundUser == null) {
    		return foundUser;
    	}
    	else {
    		return null;
    	}
    }
    
    @GetMapping("/register")
    public String getRegisterPage() {
    	return "register";
    }
    @PostMapping("/register")
    public String createUser(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
    	User foundUser = userRepository.findByUsername(username);
    	if (foundUser == null) {
    		User newUser = new User();
    		newUser.setUsername(username);
    		newUser.setPassword(password);
    		userService.Save(newUser);
    		return "login";
    	}
    	else {
    		model.addAttribute("exists", true);
    		return "register";
    	}
    }
}