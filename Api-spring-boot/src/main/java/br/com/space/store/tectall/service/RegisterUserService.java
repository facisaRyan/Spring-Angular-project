package br.com.space.store.tectall.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.space.store.tectall.enums.RoleName;
import br.com.space.store.tectall.form.RegisterUserForm;
import br.com.space.store.tectall.model.UserModel;
import br.com.space.store.tectall.repository.RoleRepository;
import br.com.space.store.tectall.repository.UserRepository;



@Service
public class RegisterUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;

	public ResponseEntity<Object> saveClient(@Valid RegisterUserForm registerUserForm) {
		UserModel user = RegisterUserForm.toUser(registerUserForm);		
		user.addRole(roleRepository.findByRolename(RoleName.ROLE_CLIENT));
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}

	public ResponseEntity<Object> saveAdmin(@Valid RegisterUserForm registerUserForm) {
		UserModel user = RegisterUserForm.toUser(registerUserForm);		
		user.addRole(roleRepository.findByRolename(RoleName.ROLE_ADMIN));
		userRepository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
	
}
