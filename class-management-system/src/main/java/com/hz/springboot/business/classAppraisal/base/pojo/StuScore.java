package com.hz.springboot.business.classAppraisal.base.pojo;

import java.util.Date;

public class StuScore {
    private Integer id;

    private Double academicScore;

    private Double notAcademicScore;

    private Double sportsScore;

    private Integer academicScoreSeq;

    private String personId;

    private String classId;

    private String yearId;

    private Date createTime;

    private Double totalScore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAcademicScore() {
        return academicScore;
    }

    public void setAcademicScore(Double academicScore) {
        this.academicScore = academicScore;
    }

    public Double getNotAcademicScore() {
        return notAcademicScore;
    }

    public void setNotAcademicScore(Double notAcademicScore) {
        this.notAcademicScore = notAcademicScore;
    }

    public Double getSportsScore() {
        return sportsScore;
    }

    public void setSportsScore(Double sportsScore) {
        this.sportsScore = sportsScore;
    }

    public Integer getAcademicScoreSeq() {
        return academicScoreSeq;
    }

    public void setAcademicScoreSeq(Integer academicScoreSeq) {
        this.academicScoreSeq = academicScoreSeq;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId == null ? null : personId.trim();
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId == null ? null : classId.trim();
    }

    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId == null ? null : yearId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }
    
    
    
    private String studentName;
    
    private String className;
    
    private String yearName;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getYearName() {
		return yearName;
	}

	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
    
    
    
    
}