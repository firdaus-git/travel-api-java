package net.travel.auth.service;

import net.travel.auth.requestVO.LoginRequestVO;
import net.travel.auth.requestVO.SignupRequestVO;
import net.travel.auth.responseVO.JwtResponseVO;
import net.travel.auth.responseVO.MessageResponseVO;

public interface UserService {
	boolean existsByUsername(String userName);
	boolean existsByEmail(String email);
	MessageResponseVO create(SignupRequestVO signUpRequest);
	JwtResponseVO authenticate(LoginRequestVO loginRequest);
}
