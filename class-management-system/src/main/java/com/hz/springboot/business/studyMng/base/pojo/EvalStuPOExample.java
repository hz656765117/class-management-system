package com.hz.springboot.business.studyMng.base.pojo;

import java.util.ArrayList;
import java.util.List;

public class EvalStuPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvalStuPOExample() {
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

        public Criteria andEvalStuKeyIsNull() {
            addCriterion("eval_stu_key is null");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyIsNotNull() {
            addCriterion("eval_stu_key is not null");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyEqualTo(String value) {
            addCriterion("eval_stu_key =", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyNotEqualTo(String value) {
            addCriterion("eval_stu_key <>", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyGreaterThan(String value) {
            addCriterion("eval_stu_key >", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyGreaterThanOrEqualTo(String value) {
            addCriterion("eval_stu_key >=", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyLessThan(String value) {
            addCriterion("eval_stu_key <", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyLessThanOrEqualTo(String value) {
            addCriterion("eval_stu_key <=", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyLike(String value) {
            addCriterion("eval_stu_key like", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyNotLike(String value) {
            addCriterion("eval_stu_key not like", value, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyIn(List<String> values) {
            addCriterion("eval_stu_key in", values, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyNotIn(List<String> values) {
            addCriterion("eval_stu_key not in", values, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyBetween(String value1, String value2) {
            addCriterion("eval_stu_key between", value1, value2, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andEvalStuKeyNotBetween(String value1, String value2) {
            addCriterion("eval_stu_key not between", value1, value2, "evalStuKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyIsNull() {
            addCriterion("student_key is null");
            return (Criteria) this;
        }

        public Criteria andStudentKeyIsNotNull() {
            addCriterion("student_key is not null");
            return (Criteria) this;
        }

        public Criteria andStudentKeyEqualTo(String value) {
            addCriterion("student_key =", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyNotEqualTo(String value) {
            addCriterion("student_key <>", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyGreaterThan(String value) {
            addCriterion("student_key >", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyGreaterThanOrEqualTo(String value) {
            addCriterion("student_key >=", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyLessThan(String value) {
            addCriterion("student_key <", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyLessThanOrEqualTo(String value) {
            addCriterion("student_key <=", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyLike(String value) {
            addCriterion("student_key like", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyNotLike(String value) {
            addCriterion("student_key not like", value, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyIn(List<String> values) {
            addCriterion("student_key in", values, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyNotIn(List<String> values) {
            addCriterion("student_key not in", values, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyBetween(String value1, String value2) {
            addCriterion("student_key between", value1, value2, "studentKey");
            return (Criteria) this;
        }

        public Criteria andStudentKeyNotBetween(String value1, String value2) {
            addCriterion("student_key not between", value1, value2, "studentKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyIsNull() {
            addCriterion("teacher_key is null");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyIsNotNull() {
            addCriterion("teacher_key is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyEqualTo(String value) {
            addCriterion("teacher_key =", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyNotEqualTo(String value) {
            addCriterion("teacher_key <>", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyGreaterThan(String value) {
            addCriterion("teacher_key >", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_key >=", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyLessThan(String value) {
            addCriterion("teacher_key <", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyLessThanOrEqualTo(String value) {
            addCriterion("teacher_key <=", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyLike(String value) {
            addCriterion("teacher_key like", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyNotLike(String value) {
            addCriterion("teacher_key not like", value, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyIn(List<String> values) {
            addCriterion("teacher_key in", values, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyNotIn(List<String> values) {
            addCriterion("teacher_key not in", values, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyBetween(String value1, String value2) {
            addCriterion("teacher_key between", value1, value2, "teacherKey");
            return (Criteria) this;
        }

        public Criteria andTeacherKeyNotBetween(String value1, String value2) {
            addCriterion("teacher_key not between", value1, value2, "teacherKey");
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

        public Criteria andTotalScoreEqualTo(Integer value) {
            addCriterion("total_score =", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotEqualTo(Integer value) {
            addCriterion("total_score <>", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThan(Integer value) {
            addCriterion("total_score >", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_score >=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThan(Integer value) {
            addCriterion("total_score <", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreLessThanOrEqualTo(Integer value) {
            addCriterion("total_score <=", value, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreIn(List<Integer> values) {
            addCriterion("total_score in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotIn(List<Integer> values) {
            addCriterion("total_score not in", values, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreBetween(Integer value1, Integer value2) {
            addCriterion("total_score between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andTotalScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("total_score not between", value1, value2, "totalScore");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyIsNull() {
            addCriterion("evaluate_Key is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyIsNotNull() {
            addCriterion("evaluate_Key is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyEqualTo(String value) {
            addCriterion("evaluate_Key =", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotEqualTo(String value) {
            addCriterion("evaluate_Key <>", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyGreaterThan(String value) {
            addCriterion("evaluate_Key >", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_Key >=", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyLessThan(String value) {
            addCriterion("evaluate_Key <", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyLessThanOrEqualTo(String value) {
            addCriterion("evaluate_Key <=", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyLike(String value) {
            addCriterion("evaluate_Key like", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotLike(String value) {
            addCriterion("evaluate_Key not like", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyIn(List<String> values) {
            addCriterion("evaluate_Key in", values, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotIn(List<String> values) {
            addCriterion("evaluate_Key not in", values, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyBetween(String value1, String value2) {
            addCriterion("evaluate_Key between", value1, value2, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotBetween(String value1, String value2) {
            addCriterion("evaluate_Key not between", value1, value2, "evaluateKey");
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