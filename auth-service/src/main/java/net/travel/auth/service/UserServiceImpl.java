package net.travel.auth.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.travel.auth.requestVO.LoginRequestVO;
import net.travel.auth.requestVO.SignupRequestVO;
import net.travel.auth.responseVO.JwtResponseVO;
import net.travel.auth.responseVO.MessageResponseVO;

import net.travel.common.model.Role;
import net.travel.common.model.User;
import net.travel.common.repository.RoleRepository;
import net.travel.common.repository.UserRepository;
import net.travel.common.enums.Roles;
import net.travel.common.security.service.UserDetailsImpl;
import net.travel.common.util.JwtUtil;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtil jwtUtil;
	
	
	
	public boolean existsByUsername(String userName) {
		
		if (userRepository.existsByUsername(userName))
			return true;
		
		return false;
		
	}
	
	public boolean existsByEmail(String email) {
		
		if (userRepository.existsByEmail(email)) 
			return true;
		
		return false;
	}
	public MessageResponseVO create(SignupRequestVO signUpRequest) {
			
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(Roles.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(Roles.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "mod":
					Role modRole = roleRepository.findByName(Roles.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				default:
					Role userRole = roleRepository.findByName(Roles.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}
		user.setRoles(roles);
		userRepository.save(user);
		return new MessageResponseVO("User created successfully!");
	}
	
	
	public JwtResponseVO authenticate(LoginRequestVO loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtil.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		return new JwtResponseVO(jwt, 
									userDetails.getId(), 
									userDetails.getUsername(), 
									userDetails.getEmail(), 
									roles);
	}
	
}
