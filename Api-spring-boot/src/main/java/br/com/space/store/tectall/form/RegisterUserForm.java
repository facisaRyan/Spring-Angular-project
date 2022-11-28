package br.com.space.store.tectall.form;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.space.store.tectall.model.UserModel;
import br.com.space.store.tectall.validator.ValidateEmail;

public class RegisterUserForm {
	
	@NotNull
	@NotEmpty
	public String username;
	@NotNull
	@NotEmpty
	public String password;
	@NotNull
	@NotEmpty
	@ValidateEmail
	public String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username.trim();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new  BCryptPasswordEncoder();
		String senhaCripto = encoder.encode(password.trim());
		this.password = senhaCripto;
	}
	
	public String getEmail() {
		return email.trim();
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserModel toUser(@Valid RegisterUserForm registerUserForm) {
		
		return new UserModel(registerUserForm);
	}
}
