package org.project.trackit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "PROFILE")
@JsonIgnoreProperties(value = { "createdDate", "updatedDate" })
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileId_generator")
	@SequenceGenerator(name = "profileId_generator", sequenceName = "profileId_seq", allocationSize=1)
	@Column(name = "profile_id")
	private long profileId;

	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;

	@Column(name = "password", nullable = false, length = 15)
	private String password;

	@Column(name = "first_name", nullable = false, length = 25)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 20)
	private String lastName;

	@Column(name = "created_date")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "PROFILE_ROLES", joinColumns = @JoinColumn(name = "profile_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles;

	@Transient
	private String profileRole;

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreatedDate() {
		return createdDate.toString();
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate.toString();
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public String getProfileRole() {
		return profileRole;
	}

	@JsonProperty
	public void setProfileRole(String profileRole) {
		this.profileRole = profileRole;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + ", roles=" + roles + "]";
	}
}
