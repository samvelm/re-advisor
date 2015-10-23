package com.m4.ra.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.m4.ra.model.ref.Role;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -6904012135620052879L;

	public User() {
	}

	public User(String firstName, String lastName, String userName,
			String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "role_type", nullable = false, columnDefinition = "enum('ADMIN', 'COMPANY_ADMIN', 'SIMPLE_USER')")
	@Enumerated(EnumType.STRING)
	private Role role = Role.SIMPLE_USER;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	@Transient
	private String confirmPassword;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "enabled")
	private boolean enabled = true;

	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;

	public Long getId() {
		return id;
	}

	@Autowired
	private void setId(Long id) {
		this.id = id;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// - - - - - - - - - - - - - - - - - - - - - - - -
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean equals(User obj) {
		User other = (User) obj;
		return other.id.equals(this.id);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(lastName);
		sb.append("\t" + firstName);
		sb.append("\t" + userName);
		sb.append("\t" + email);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

}
