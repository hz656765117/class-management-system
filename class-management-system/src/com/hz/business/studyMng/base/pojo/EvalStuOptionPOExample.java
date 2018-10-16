package com.hz.business.studyMng.base.pojo;

import java.util.ArrayList;
import java.util.List;

public class EvalStuOptionPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvalStuOptionPOExample() {
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

        public Criteria andStuOptionKeyIsNull() {
            addCriterion("stu_option_key is null");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyIsNotNull() {
            addCriterion("stu_option_key is not null");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyEqualTo(Integer value) {
            addCriterion("stu_option_key =", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyNotEqualTo(Integer value) {
            addCriterion("stu_option_key <>", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyGreaterThan(Integer value) {
            addCriterion("stu_option_key >", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyGreaterThanOrEqualTo(Integer value) {
            addCriterion("stu_option_key >=", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyLessThan(Integer value) {
            addCriterion("stu_option_key <", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyLessThanOrEqualTo(Integer value) {
            addCriterion("stu_option_key <=", value, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyIn(List<Integer> values) {
            addCriterion("stu_option_key in", values, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyNotIn(List<Integer> values) {
            addCriterion("stu_option_key not in", values, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyBetween(Integer value1, Integer value2) {
            addCriterion("stu_option_key between", value1, value2, "stuOptionKey");
            return (Criteria) this;
        }

        public Criteria andStuOptionKeyNotBetween(Integer value1, Integer value2) {
            addCriterion("stu_option_key not between", value1, value2, "stuOptionKey");
            return (Criteria) this;
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

        public Criteria andOptionKeyIsNull() {
            addCriterion("option_key is null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIsNotNull() {
            addCriterion("option_key is not null");
            return (Criteria) this;
        }

        public Criteria andOptionKeyEqualTo(String value) {
            addCriterion("option_key =", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotEqualTo(String value) {
            addCriterion("option_key <>", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThan(String value) {
            addCriterion("option_key >", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyGreaterThanOrEqualTo(String value) {
            addCriterion("option_key >=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThan(String value) {
            addCriterion("option_key <", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLessThanOrEqualTo(String value) {
            addCriterion("option_key <=", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyLike(String value) {
            addCriterion("option_key like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotLike(String value) {
            addCriterion("option_key not like", value, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyIn(List<String> values) {
            addCriterion("option_key in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotIn(List<String> values) {
            addCriterion("option_key not in", values, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyBetween(String value1, String value2) {
            addCriterion("option_key between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andOptionKeyNotBetween(String value1, String value2) {
            addCriterion("option_key not between", value1, value2, "optionKey");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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