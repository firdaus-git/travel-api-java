package net.travel.auth.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.travel.auth.requestVO.LoginRequestVO;
import net.travel.auth.requestVO.SignupRequestVO;
import net.travel.auth.responseVO.JwtResponseVO;
import net.travel.auth.responseVO.MessageResponseVO;
import net.travel.auth.service.UserService;


@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AuthController {

	@Autowired
	UserService userService;
	
	@PostMapping("/signin")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequestVO loginRequest) {
		
		JwtResponseVO jwtResponseVO = userService.authenticate(loginRequest);
		
		return ResponseEntity.ok(jwtResponseVO);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequestVO signUpRequest) {
			
		if (userService.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseVO("Error: Username is already taken!"));
		}
		
		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponseVO("Error: Email is already in use!"));
		}
				
		MessageResponseVO messageResponseVO = userService.create(signUpRequest);
		
		return ResponseEntity.ok(messageResponseVO);
	}
}
