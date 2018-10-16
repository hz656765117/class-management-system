package com.hz.business.studyMng.base.pojo;

import java.util.ArrayList;
import java.util.List;

public class EvaluatePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluatePOExample() {
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

        public Criteria andEvaluateKeyIsNull() {
            addCriterion("evaluate_key is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyIsNotNull() {
            addCriterion("evaluate_key is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyEqualTo(String value) {
            addCriterion("evaluate_key =", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotEqualTo(String value) {
            addCriterion("evaluate_key <>", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyGreaterThan(String value) {
            addCriterion("evaluate_key >", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_key >=", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyLessThan(String value) {
            addCriterion("evaluate_key <", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyLessThanOrEqualTo(String value) {
            addCriterion("evaluate_key <=", value, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyIn(List<String> values) {
            addCriterion("evaluate_key in", values, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andEvaluateKeyNotIn(List<String> values) {
            addCriterion("evaluate_key not in", values, "evaluateKey");
            return (Criteria) this;
        }

//        public Criteria andEvaluateKeyBetween(Integer value1, Integer value2) {
//            addCriterion("evaluate_key between", value1, value2, "evaluateKey");
//            return (Criteria) this;
//        }

        public Criteria andEvaluateKeyNotBetween(String value1, String value2) {
            addCriterion("evaluate_key not between", value1, value2, "evaluateKey");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyIsNull() {
            addCriterion("year_term_key is null");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyIsNotNull() {
            addCriterion("year_term_key is not null");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyEqualTo(String value) {
            addCriterion("year_term_key =", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyNotEqualTo(String value) {
            addCriterion("year_term_key <>", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyGreaterThan(String value) {
            addCriterion("year_term_key >", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyGreaterThanOrEqualTo(String value) {
            addCriterion("year_term_key >=", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyLessThan(String value) {
            addCriterion("year_term_key <", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyLessThanOrEqualTo(String value) {
            addCriterion("year_term_key <=", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyLike(String value) {
            addCriterion("year_term_key like", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyNotLike(String value) {
            addCriterion("year_term_key not like", value, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyIn(List<String> values) {
            addCriterion("year_term_key in", values, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyNotIn(List<String> values) {
            addCriterion("year_term_key not in", values, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyBetween(String value1, String value2) {
            addCriterion("year_term_key between", value1, value2, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andYearTermKeyNotBetween(String value1, String value2) {
            addCriterion("year_term_key not between", value1, value2, "yearTermKey");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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