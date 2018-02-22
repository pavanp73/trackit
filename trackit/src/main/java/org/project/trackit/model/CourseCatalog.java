package org.project.trackit.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.project.trackit.util.DateFormatUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "COURSE_CATALOG")
public class CourseCatalog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "courseId_generator")
	@SequenceGenerator(name = "courseId_generator", sequenceName = "courseId_seq", allocationSize = 1)
	@Column(name = "course_id")
	private long courseId;

	@Column(name = "course_name", nullable = false, length = 35)
	private String courseName;

	@Column(name = "course_author", nullable = false, length = 35)
	private String authorName;

	@Column(name = "total_chapters", nullable = false)
	private int totalChapters;

	@Column(name = "created_date")
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column(name = "updated_date")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@OneToMany(mappedBy = "courseBasicInfo")
	private Set<ProfileCourses> profileCourses;

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getCreatedDate() {
		return DateFormatUtil.convert(createdDate);
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdateddate() {
		return DateFormatUtil.convert(updatedDate);
	}

	public void setUpdateddate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getTotalChapters() {
		return totalChapters;
	}

	public void setTotalChapters(int totalChapters) {
		this.totalChapters = totalChapters;
	}

	@JsonIgnore
	public Set<ProfileCourses> getProfileCourses() {
		return profileCourses;
	}

	public void setProfileCourses(Set<ProfileCourses> profileCourses) {
		this.profileCourses = profileCourses;
	}

	@Override
	public String toString() {
		return "CourseCatalog [courseId=" + courseId + ", courseName=" + courseName + ", authorName=" + authorName
				+ ", totalChapters=" + totalChapters + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate
				+ ", profileCourses=" + profileCourses + "]";
	}

}
