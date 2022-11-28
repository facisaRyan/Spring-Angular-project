package br.com.space.store.tectall.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.space.store.tectall.form.RegisterUserForm;
import br.com.space.store.tectall.service.RegisterUserService;



@RestController
@RequestMapping("/users")
public class RegisterUserController {
	
	
	@Autowired
	private RegisterUserService registerUserService;
	
	
	@PostMapping("/client")
	public ResponseEntity<Object> saveUsuerClient(@RequestBody @Valid RegisterUserForm registerUserForm ){
		return registerUserService.saveClient(registerUserForm);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Object> saveUserAdmin(@RequestBody @Valid RegisterUserForm registerUserForm ){
		return registerUserService.saveAdmin(registerUserForm);
	}
}