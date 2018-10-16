package com.hz.business.basicDataMng.base.pojo;

public class StudentPO {
    private String studentKey;

    private String name;

    private String sex;

    private String idcardNumber;

    private String classKey;
    
    private String majorKey;
    
    private String academyKey;
    
    private String majorName;
    
   private String className;
   
   private String academyName;

    public String getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey == null ? null : studentKey.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getIdcardNumber() {
        return idcardNumber;
    }

    public void setIdcardNumber(String idcardNumber) {
        this.idcardNumber = idcardNumber == null ? null : idcardNumber.trim();
    }

    public String getClassKey() {
        return classKey;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey == null ? null : classKey.trim();
    }

	public String getMajorKey() {
		return majorKey;
	}

	public void setMajorKey(String majorKey) {
		this.majorKey = majorKey;
	}

	public String getAcademyKey() {
		return academyKey;
	}

	public void setAcademyKey(String academyKey) {
		this.academyKey = academyKey;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	public String getAcademyName() {
		return academyName;
	}
	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
}