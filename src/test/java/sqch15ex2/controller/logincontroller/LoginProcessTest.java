package sqch15ex2.controller.logincontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import sqch15ex2.controller.LoginController;
import sqch15ex2.controller.LoginProcessor;

@ExtendWith(MockitoExtension.class)
@DisplayName("로그인 POST 방법 요청 처리 액션 검증")
class LoginProcessTest {

	@Mock
	private Model model;

	@Mock
	private LoginProcessor loginProcessor;

	@InjectMocks
	private LoginController loginController;

	@Test
	@DisplayName("로그인 액션 메소드 - 로그인 실패 처리 시험")
	void loginFailureTest() {
		given(loginProcessor.isLoggedIn()).willReturn(false);
		String viewName = loginController.loginProcess(model, "username",
				"password");
		assertEquals("login.html", viewName);
		verify(model)
		.addAttribute("loginStatusMsg", "로그인 하셔야 됩니다.");		
	}
	
	@Test
	@DisplayName("로그인 액션 메소드 - 로그인 성공 처리 시험")
	void loginSuccessTest() {
		given(loginProcessor.isLoggedIn()).willReturn(true);

		String username = "natalie";
		String viewName = loginController.loginProcess(model, username,
				"password");
		assertEquals("login.html", viewName);
		String msgExpected = "현재 '" + username + "'가 로그인한 상태입니다.";
		verify(model)
				.addAttribute("loginStatusMsg", msgExpected);
	}

}
