package com.hz.springboot.business.studyMng.base.pojo;

public class EvaluateOptionPO {
    private Integer optionKey;

    private String content;

    private String evaluateKey;

    private Integer seq;
    
    private Integer score;

    public Integer getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(Integer optionKey) {
        this.optionKey = optionKey;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getEvaluateKey() {
        return evaluateKey;
    }

    public void setEvaluateKey(String evaluateKey) {
        this.evaluateKey = evaluateKey == null ? null : evaluateKey.trim();
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
}