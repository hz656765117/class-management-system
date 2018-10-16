package com.hz.business.studyMng.base.pojo;

public class EvalStuPO {
    private String evalStuKey;

    private String studentKey;

    private String teacherKey;

    private Integer totalScore;

    private String evaluateKey;

    public String getEvalStuKey() {
        return evalStuKey;
    }

    public void setEvalStuKey(String evalStuKey) {
        this.evalStuKey = evalStuKey == null ? null : evalStuKey.trim();
    }

    public String getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey == null ? null : studentKey.trim();
    }

    public String getTeacherKey() {
        return teacherKey;
    }

    public void setTeacherKey(String teacherKey) {
        this.teacherKey = teacherKey == null ? null : teacherKey.trim();
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
        this.evaluateKey = evaluateKey == null ? null : evaluateKey.trim();
    }
}