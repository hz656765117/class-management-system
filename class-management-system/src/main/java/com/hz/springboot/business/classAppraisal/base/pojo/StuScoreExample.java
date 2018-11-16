package com.hz.springboot.business.classAppraisal.base.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuScoreExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuScoreExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreIsNull() {
            addCriterion("academic_score is null");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreIsNotNull() {
            addCriterion("academic_score is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreEqualTo(Double value) {
            addCriterion("academic_score =", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreNotEqualTo(Double value) {
            addCriterion("academic_score <>", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreGreaterThan(Double value) {
            addCriterion("academic_score >", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("academic_score >=", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreLessThan(Double value) {
            addCriterion("academic_score <", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreLessThanOrEqualTo(Double value) {
            addCriterion("academic_score <=", value, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreIn(List<Double> values) {
            addCriterion("academic_score in", values, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreNotIn(List<Double> values) {
            addCriterion("academic_score not in", values, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreBetween(Double value1, Double value2) {
            addCriterion("academic_score between", value1, value2, "academicScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreNotBetween(Double value1, Double value2) {
            addCriterion("academic_score not between", value1, value2, "academicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreIsNull() {
            addCriterion("not_academic_score is null");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreIsNotNull() {
            addCriterion("not_academic_score is not null");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreEqualTo(Double value) {
            addCriterion("not_academic_score =", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreNotEqualTo(Double value) {
            addCriterion("not_academic_score <>", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreGreaterThan(Double value) {
            addCriterion("not_academic_score >", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("not_academic_score >=", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreLessThan(Double value) {
            addCriterion("not_academic_score <", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreLessThanOrEqualTo(Double value) {
            addCriterion("not_academic_score <=", value, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreIn(List<Double> values) {
            addCriterion("not_academic_score in", values, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreNotIn(List<Double> values) {
            addCriterion("not_academic_score not in", values, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreBetween(Double value1, Double value2) {
            addCriterion("not_academic_score between", value1, value2, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andNotAcademicScoreNotBetween(Double value1, Double value2) {
            addCriterion("not_academic_score not between", value1, value2, "notAcademicScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreIsNull() {
            addCriterion("sports_score is null");
            return (Criteria) this;
        }

        public Criteria andSportsScoreIsNotNull() {
            addCriterion("sports_score is not null");
            return (Criteria) this;
        }

        public Criteria andSportsScoreEqualTo(Double value) {
            addCriterion("sports_score =", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreNotEqualTo(Double value) {
            addCriterion("sports_score <>", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreGreaterThan(Double value) {
            addCriterion("sports_score >", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("sports_score >=", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreLessThan(Double value) {
            addCriterion("sports_score <", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreLessThanOrEqualTo(Double value) {
            addCriterion("sports_score <=", value, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreIn(List<Double> values) {
            addCriterion("sports_score in", values, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreNotIn(List<Double> values) {
            addCriterion("sports_score not in", values, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreBetween(Double value1, Double value2) {
            addCriterion("sports_score between", value1, value2, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andSportsScoreNotBetween(Double value1, Double value2) {
            addCriterion("sports_score not between", value1, value2, "sportsScore");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqIsNull() {
            addCriterion("academic_score_seq is null");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqIsNotNull() {
            addCriterion("academic_score_seq is not null");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqEqualTo(Integer value) {
            addCriterion("academic_score_seq =", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqNotEqualTo(Integer value) {
            addCriterion("academic_score_seq <>", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqGreaterThan(Integer value) {
            addCriterion("academic_score_seq >", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("academic_score_seq >=", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqLessThan(Integer value) {
            addCriterion("academic_score_seq <", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqLessThanOrEqualTo(Integer value) {
            addCriterion("academic_score_seq <=", value, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqIn(List<Integer> values) {
            addCriterion("academic_score_seq in", values, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqNotIn(List<Integer> values) {
            addCriterion("academic_score_seq not in", values, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqBetween(Integer value1, Integer value2) {
            addCriterion("academic_score_seq between", value1, value2, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andAcademicScoreSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("academic_score_seq not between", value1, value2, "academicScoreSeq");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNull() {
            addCriterion("person_id is null");
            return (Criteria) this;
        }

        public Criteria andPersonIdIsNotNull() {
            addCriterion("person_id is not null");
            return (Criteria) this;
        }

        public Criteria andPersonIdEqualTo(String value) {
            addCriterion("person_id =", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotEqualTo(String value) {
            addCriterion("person_id <>", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThan(String value) {
            addCriterion("person_id >", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdGreaterThanOrEqualTo(String value) {
            addCriterion("person_id >=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThan(String value) {
            addCriterion("person_id <", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLessThanOrEqualTo(String value) {
            addCriterion("person_id <=", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdLike(String value) {
            addCriterion("person_id like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotLike(String value) {
            addCriterion("person_id not like", value, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdIn(List<String> values) {
            addCriterion("person_id in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotIn(List<String> values) {
            addCriterion("person_id not in", values, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdBetween(String value1, String value2) {
            addCriterion("person_id between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andPersonIdNotBetween(String value1, String value2) {
            addCriterion("person_id not between", value1, value2, "personId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(String value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(String value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(String value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(String value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(String value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLike(String value) {
            addCriterion("class_id like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotLike(String value) {
            addCriterion("class_id not like", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<String> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<String> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(String value1, String value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(String value1, String value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNull() {
            addCriterion("year_id is null");
            return (Criteria) this;
        }

        public Criteria andYearIdIsNotNull() {
            addCriterion("year_id is not null");
            return (Criteria) this;
        }

        public Criteria andYearIdEqualTo(String value) {
            addCriterion("year_id =", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotEqualTo(String value) {
            addCriterion("year_id <>", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThan(String value) {
            addCriterion("year_id >", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdGreaterThanOrEqualTo(String value) {
            addCriterion("year_id >=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThan(String value) {
            addCriterion("year_id <", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLessThanOrEqualTo(String value) {
            addCriterion("year_id <=", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdLike(String value) {
            addCriterion("year_id like", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotLike(String value) {
            addCriterion("year_id not like", value, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdIn(List<String> values) {
            addCriterion("year_id in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotIn(List<String> values) {
            addCriterion("year_id not in", values, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdBetween(String value1, String value2) {
            addCriterion("year_id between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andYearIdNotBetween(String value1, String value2) {
            addCriterion("year_id not between", value1, value2, "yearId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNull() {
            addCriterion("total_score is null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIsNotNull() {
            addCriterion("total_score is not null");
            return (Criteria) this;
        }

        public Criteria andTotalScoreEqualTo(Double value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Double value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Double value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Double value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Double value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Double value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Double> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Double> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Double value1, Double value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Double value1, Double value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}