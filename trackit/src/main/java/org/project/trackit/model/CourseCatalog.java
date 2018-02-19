package org.project.trackit.model;

import java.util.Date;

public class CourseCatalog {

	private long courseId;
	private String courseName;
	private String authorName;
	private Date createdDate;
	private Date updateddate;
	private int totalChapters;

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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public int getTotalChapters() {
		return totalChapters;
	}

	public void setTotalChapters(int totalChapters) {
		this.totalChapters = totalChapters;
	}

	@Override
	public String toString() {
		return "CourseCatalog [courseId=" + courseId + ", courseName=" + courseName + ", authorName=" + authorName
				+ ", createdDate=" + createdDate + ", updateddate=" + updateddate + ", totalChapters=" + totalChapters
				+ "]";
	}

}
