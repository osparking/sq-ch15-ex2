package sqch15ex2.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Component
@RequestScope
@Data
public class LoginProcessor {
	private String username;
	private String password;
	
	public boolean isLoggedIn() {
		if ("natalie".equals(username) && "1234".equals(password)) {
			return true;
		} else {
			return false;
		}
	}

}
