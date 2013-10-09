package org.domain.open18.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "MEMBER", uniqueConstraints = {
	@UniqueConstraint(columnNames = "username"),
	@UniqueConstraint(columnNames = "email_address")
})
public abstract class Member implements Serializable {

	private Long id;
	private String username;
	private String passwordHash;
	private String emailAddress;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	@Length(min = 6, max = 40)
	@NotNull
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password_hash", nullable = false)
	@NotNull
	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Column(name = "email_address", nullable = false)
	@Email
	@Length(max = 80)
	@NotNull
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
}
