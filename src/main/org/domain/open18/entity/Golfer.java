package org.domain.open18.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.validator.constraints.Length;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Entity
@PrimaryKeyJoinColumn(name = "MEMBER_ID")
@Table(name = "GOLFER")
@Name("newGolfer")
@Scope(ScopeType.EVENT)
public class Golfer extends Member implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 839842193678966291L;
	
	private String lastName;
	private String firstName;
	private Gender gender;
	private Date dateJoined;
	private Date dateOfBirth;
	private String location;

	@Column(name = "last_name", nullable = false)
	@NotNull
	@Length(max = 40)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "first_name", nullable = false)
	@NotNull
	@Length(max = 40)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Transient
	public String getName() {
		return firstName + ' ' + lastName;
	}

	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "joined", nullable = false, updatable = false)
	@NotNull
	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dob")
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
