package br.com.space.store.tectall.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.space.store.tectall.model.UserModel;
import br.com.space.store.tectall.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public UserDetails getUserByEmail(String email) {
		
		UserModel usuario = userRepository.findByEmail(email).orElseThrow(() 
				-> new UsernameNotFoundException("usuario não encontrado: " + email));
		
		return new User(usuario.getEmail(), usuario.getPassword(), true, true, true, true, usuario.getAuthorities());
	}
	
}