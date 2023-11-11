package sqch15ex2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
	private final LoginProcessor loginProcessor;
	
	@GetMapping("/")
	public String loginForm() {
		return "login.html";
	}
	
	@PostMapping("/login")
	public String loginProcess(Model model,
			@RequestParam String username,
			@RequestParam String password) {
		
		loginProcessor.setUsername(username);
		loginProcessor.setPassword(password);
		
		String loginStatusMsg = "로그인 하셔야 됩니다.";
		if (loginProcessor.isLoggedIn()) {
			loginStatusMsg = "현재 '" + username + "'가 로그인한 상태입니다." ;
		} 
		model.addAttribute("loginStatusMsg", loginStatusMsg);
				
		return "login.html";
	}

}
