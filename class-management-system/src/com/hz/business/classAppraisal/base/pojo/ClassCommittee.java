package com.hz.business.classAppraisal.base.pojo;

import java.util.Date;

public class ClassCommittee {
    private Integer id;

	private String classKey;

	private String studentKey;

	private String banweiCode;

	private Date createTime;

	private Integer deleteFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassKey() {
		return classKey;
	}

	public void setClassKey(String classKey) {
		this.classKey = classKey == null ? null : classKey.trim();
	}

	public String getStudentKey() {
		return studentKey;
	}

	public void setStudentKey(String studentKey) {
		this.studentKey = studentKey == null ? null : studentKey.trim();
	}

	public String getBanweiCode() {
		return banweiCode;
	}

	public void setBanweiCode(String banweiCode) {
		this.banweiCode = banweiCode == null ? null : banweiCode.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	 
    
    private String studentName;
    
    private String className;

    

    
    
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
    
    
}