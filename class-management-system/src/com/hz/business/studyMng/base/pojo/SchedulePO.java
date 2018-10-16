package com.hz.business.studyMng.base.pojo;

public class SchedulePO {
    private String scheduleKey;

    private Integer weekSeq;

    private Integer orderSeq;

    private String teacherKey;

    private Integer classCourseId;

    private Integer startWeekSeq;

    private Integer endWeekSeq;

    private String classKey;
    
    private String teacherName;
    private String courseName;

    public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getScheduleKey() {
        return scheduleKey;
    }

    public void setScheduleKey(String scheduleKey) {
        this.scheduleKey = scheduleKey == null ? null : scheduleKey.trim();
    }

    public Integer getWeekSeq() {
        return weekSeq;
    }

    public void setWeekSeq(Integer weekSeq) {
        this.weekSeq = weekSeq;
    }

    public Integer getOrderSeq() {
        return orderSeq;
    }

    public void setOrderSeq(Integer orderSeq) {
        this.orderSeq = orderSeq;
    }

    public String getTeacherKey() {
        return teacherKey;
    }

    public void setTeacherKey(String teacherKey) {
        this.teacherKey = teacherKey == null ? null : teacherKey.trim();
    }

    public Integer getClassCourseId() {
        return classCourseId;
    }

    public void setClassCourseId(Integer classCourseId) {
        this.classCourseId = classCourseId;
    }

    public Integer getStartWeekSeq() {
        return startWeekSeq;
    }

    public void setStartWeekSeq(Integer startWeekSeq) {
        this.startWeekSeq = startWeekSeq;
    }

    public Integer getEndWeekSeq() {
        return endWeekSeq;
    }

    public void setEndWeekSeq(Integer endWeekSeq) {
        this.endWeekSeq = endWeekSeq;
    }

    public String getClassKey() {
        return classKey;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey == null ? null : classKey.trim();
    }
}