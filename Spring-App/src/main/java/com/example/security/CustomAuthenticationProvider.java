package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.service.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;
    
    @Bean
	public org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    	
	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		// TODO Auto-generated method stub
        String username=auth.getName();
        String password=auth.getCredentials().toString();
        System.out.println(passwordEncoder().encode(password));
        System.out.println(passwordEncoder().encode(userService.findUserByUsername(username).getPassword()));
        if(passwordEncoder().matches(password, userService.findUserByUsername(username).getPassword())) {
        	return new UsernamePasswordAuthenticationToken(username, password);
        }

        else{
        	throw new BadCredentialsException("External system authentication failed");
        }
	}

	@Override
	public boolean supports(Class<?> auth) {
		// TODO Auto-generated method stub
		return auth.equals(UsernamePasswordAuthenticationToken.class);
	}

}
