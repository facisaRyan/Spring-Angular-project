package br.com.space.store.tectall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.space.store.tectall.service.UserService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		return userService.getUserByEmail(email);
	}
}
