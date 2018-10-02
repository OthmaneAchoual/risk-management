package be.issep.riskmanagement.api.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200", allowCredentials="true")
@RequestMapping("/session")
public class SessionController {
	
	@GetMapping("/me")
	public String current(Principal principal) {
		if (principal != null)
			return principal.getName();
		else
			return "guest";
	}
}
