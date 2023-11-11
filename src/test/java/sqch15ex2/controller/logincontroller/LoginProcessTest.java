package sqch15ex2.controller.logincontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import sqch15ex2.controller.LoginController;
import sqch15ex2.controller.LoginProcessor;

@ExtendWith(MockitoExtension.class)
class LoginProcessTest {

	@Mock
	private Model model;

	@Mock
	private LoginProcessor loginProcessor;

	@InjectMocks
	private LoginController loginController;

	@Test
	void loginSuccessTest() {
		given(loginProcessor.isLoggedIn()).willReturn(true);

		String username = "natalie";
		String viewName = loginController.loginProcess(model, username,
				"password");
	}

}
