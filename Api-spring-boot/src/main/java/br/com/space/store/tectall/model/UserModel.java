package br.com.space.store.tectall.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.space.store.tectall.form.RegisterUserForm;



@Entity
@Table(name = "TB_users")
public class UserModel implements UserDetails, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID userId;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@ManyToMany
	@JoinTable(name = "users_roles", 
	joinColumns = @JoinColumn(name = "usuario_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleModel> roles;
	
	public UserModel() {}
	
	public UserModel(@Valid RegisterUserForm registerUserForm) {
		this.roles = new ArrayList<RoleModel>();
		this.username = registerUserForm.getUsername();
		this.password = registerUserForm.getPassword();
		this.email = registerUserForm.getEmail();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	public String getPassword() {
		return this.password;
	}
	@Override
	public String getUsername() {
		return this.email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID uuid) {
		this.userId = uuid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public void addRole(RoleModel role) {
		this.roles.add(role);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}
	
	
	
}