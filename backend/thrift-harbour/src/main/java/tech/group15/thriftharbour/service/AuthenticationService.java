package tech.group15.thriftharbour.service;

import org.springframework.web.servlet.view.RedirectView;
import tech.group15.thriftharbour.dto.*;
import tech.group15.thriftharbour.model.User;

public interface AuthenticationService {
  User signUp(SignUpRequest signUpRequest);
  SignInResponse signIn(SignInRequest signInRequest);

  SignInResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

  ForgotPassResponse forgotPassword(String userEmail);

  Object resetPassTokenVerify(String token);

  Object resetPassword(ResetPassRequest resetPassRequest);
}
