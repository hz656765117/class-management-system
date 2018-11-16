package com.hz.springboot.business.studyMng.base.pojo;

public class ClassBookPO {
    private String classBookKey;

    private String bookName;

    private String version;

    private Integer countNum;

    private Integer onlyMoney;

    public String getClassBookKey() {
        return classBookKey;
    }

    public void setClassBookKey(String classBookKey) {
        this.classBookKey = classBookKey == null ? null : classBookKey.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

    public Integer getOnlyMoney() {
        return onlyMoney;
    }

    public void setOnlyMoney(Integer onlyMoney) {
        this.onlyMoney = onlyMoney;
    }
}