package com.hz.business.studyMng.base.pojo;

public class EvalStuOptionPO {
    private Integer stuOptionKey;

    private String evalStuKey;

    private String optionKey;

    private Integer score;

    public Integer getStuOptionKey() {
        return stuOptionKey;
    }

    public void setStuOptionKey(Integer stuOptionKey) {
        this.stuOptionKey = stuOptionKey;
    }

    public String getEvalStuKey() {
        return evalStuKey;
    }

    public void setEvalStuKey(String evalStuKey) {
        this.evalStuKey = evalStuKey == null ? null : evalStuKey.trim();
    }

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String optionKey) {
        this.optionKey = optionKey == null ? null : optionKey.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}