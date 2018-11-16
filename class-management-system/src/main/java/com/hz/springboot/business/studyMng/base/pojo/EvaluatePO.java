package com.hz.springboot.business.studyMng.base.pojo;

public class EvaluatePO {
    private String evaluateKey;
    private String title;
    private String yearTermKey;
    private Integer status;
    
    private String yearName;
    private String yearTermName;

    private String teacherName;
    private String studentName;
    private Integer totalScore;
    private String teacherKey;
    private String studentKey;
    
    public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getTeacherKey() {
		return teacherKey;
	}

	public void setTeacherKey(String teacherKey) {
		this.teacherKey = teacherKey;
	}

	public String getStudentKey() {
		return studentKey;
	}

	public void setStudentKey(String studentKey) {
		this.studentKey = studentKey;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public Integer getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public String getEvaluateKey() {
        return evaluateKey;
    }

    public void setEvaluateKey(String evaluateKey) {
        this.evaluateKey = evaluateKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getYearTermKey() {
        return yearTermKey;
    }

    public void setYearTermKey(String yearTermKey) {
        this.yearTermKey = yearTermKey == null ? null : yearTermKey.trim();
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
	public String getYearName() {
		return yearName;
	}
	public void setYearName(String yearName) {
		this.yearName = yearName;
	}
	public String getYearTermName() {
		return yearTermName;
	}
	public void setYearTermName(String yearTermName) {
		this.yearTermName = yearTermName;
	}
}