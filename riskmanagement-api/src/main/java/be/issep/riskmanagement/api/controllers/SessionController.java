package be.issep.riskmanagement.api.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

	@PostMapping("/login")
	public String login(
			@RequestParam("username") String username, 
			@RequestParam("password") String password,
			HttpSession session
	) {
		if(username.equals("admin") && password.equals("admin")) {
			session.setAttribute("loggedIn", "admin");
			return "success";
		} else {
			return "failure";
		}
	}
	
	@GetMapping("/current")
	public String current(HttpSession session) {
		return (String)session.getAttribute("loggedIn");
	}
	
	@PostMapping("/logout")
	public void logout(
			HttpSession session
	) {
		session.invalidate();
	}
}
