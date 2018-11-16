package com.hz.springboot.business.basicDataMng.base.pojo;

import java.util.Date;

public class MajorPO {
    private String majorKey;

    private String majorName;

    private String academyKey;

    private Date createDate;
    
    private String academyName;
    
    private Double money;
    
    private AcademyPO academyPO;

    public String getMajorKey() {
        return majorKey;
    }

    public void setMajorKey(String majorKey) {
        this.majorKey = majorKey == null ? null : majorKey.trim();
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName == null ? null : majorName.trim();
    }

    public String getAcademyKey() {
        return academyKey;
    }

    public void setAcademyKey(String academyKey) {
        this.academyKey = academyKey == null ? null : academyKey.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	public AcademyPO getAcademyPO() {
		return academyPO;
	}
	public void setAcademyPO(AcademyPO academyPO) {
		this.academyPO = academyPO;
	}

	public String getAcademyName() {
		return academyName;
	}
	public void setAcademyName(String academyName) {
		this.academyName = academyName;
	}
	public Double getMoney() {
		return money;
	}
	public void setMoney(Double money) {
		this.money = money;
	}
}