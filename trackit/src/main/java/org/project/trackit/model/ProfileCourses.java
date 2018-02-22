package org.project.trackit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.project.trackit.util.DateFormatUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name = "PROFILE_COURSES")
public class ProfileCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profileCourseId_generator")
	@SequenceGenerator(name = "profileCourseId_generator", sequenceName = "profileCourseId_seq", allocationSize = 1)
	@Column(name = "profile_course_id")
	private long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private CourseCatalog courseBasicInfo;

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false)
	private Date endDate;

	@Column(name = "completed_percentage", nullable = false)
	private double completedPercentage;

	@Column(name = "per_day_chapters", nullable = false, length = 15)
	private int perDayChapters;

	@Column(name = "status", nullable = false, length = 15)
	private String status;

	@Column(name = "created_date")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "profile_id")
	private Profile profile;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStartDate() {
		return DateFormatUtil.convert(startDate);
	}

	public void setStartDate(String startDate) {
		this.startDate = DateFormatUtil.read(startDate+" 00:00");
	}

	public String getEndDate() {
		return DateFormatUtil.convert(endDate);
	}

	public void setEndDate(String endDate) {
		this.endDate = DateFormatUtil.read(endDate+" 00:00");
	}

	public double getCompletedPercentage() {
		return completedPercentage;
	}

	public void setCompletedPercentage(double completedPercentage) {
		this.completedPercentage = completedPercentage;
	}

	public int getPerDayChapters() {
		return perDayChapters;
	}

	public void setPerDayChapters(int perDayChapters) {
		this.perDayChapters = perDayChapters;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedDate() {
		return DateFormatUtil.convert(createdDate);
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return DateFormatUtil.convert(updatedDate);
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@JsonIgnore
	public Profile getProfile() {
		return profile;
	}

	@JsonProperty
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public CourseCatalog getCourseBasicInfo() {
		return courseBasicInfo;
	}

	public void setCourseBasicInfo(CourseCatalog courseBasicInfo) {
		this.courseBasicInfo = courseBasicInfo;
	}

	@Override
	public String toString() {
		return "ProfileCourses [id=" + id + ", courseBasicInfo=" + courseBasicInfo + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", completedPercentage=" + completedPercentage + ", perDayChapters="
				+ perDayChapters + ", status=" + status + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", profile=" + profile + "]";
	}

}
