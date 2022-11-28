package br.com.space.store.tectall.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<ValidateEmail, String> {
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public void initialize(ValidateEmail constraintAnnotation) {
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return (validateCPF(email));
	}

	private boolean validateCPF(String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
	}
}
