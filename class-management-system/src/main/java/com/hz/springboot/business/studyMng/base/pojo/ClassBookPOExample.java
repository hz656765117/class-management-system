package com.hz.springboot.business.studyMng.base.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClassBookPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassBookPOExample() {
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

        public Criteria andClassBookKeyIsNull() {
            addCriterion("class_book_key is null");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyIsNotNull() {
            addCriterion("class_book_key is not null");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyEqualTo(String value) {
            addCriterion("class_book_key =", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyNotEqualTo(String value) {
            addCriterion("class_book_key <>", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyGreaterThan(String value) {
            addCriterion("class_book_key >", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyGreaterThanOrEqualTo(String value) {
            addCriterion("class_book_key >=", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyLessThan(String value) {
            addCriterion("class_book_key <", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyLessThanOrEqualTo(String value) {
            addCriterion("class_book_key <=", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyLike(String value) {
            addCriterion("class_book_key like", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyNotLike(String value) {
            addCriterion("class_book_key not like", value, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyIn(List<String> values) {
            addCriterion("class_book_key in", values, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyNotIn(List<String> values) {
            addCriterion("class_book_key not in", values, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyBetween(String value1, String value2) {
            addCriterion("class_book_key between", value1, value2, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andClassBookKeyNotBetween(String value1, String value2) {
            addCriterion("class_book_key not between", value1, value2, "classBookKey");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNull() {
            addCriterion("book_name is null");
            return (Criteria) this;
        }

        public Criteria andBookNameIsNotNull() {
            addCriterion("book_name is not null");
            return (Criteria) this;
        }

        public Criteria andBookNameEqualTo(String value) {
            addCriterion("book_name =", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotEqualTo(String value) {
            addCriterion("book_name <>", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThan(String value) {
            addCriterion("book_name >", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameGreaterThanOrEqualTo(String value) {
            addCriterion("book_name >=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThan(String value) {
            addCriterion("book_name <", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLessThanOrEqualTo(String value) {
            addCriterion("book_name <=", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameLike(String value) {
            addCriterion("book_name like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotLike(String value) {
            addCriterion("book_name not like", value, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameIn(List<String> values) {
            addCriterion("book_name in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotIn(List<String> values) {
            addCriterion("book_name not in", values, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameBetween(String value1, String value2) {
            addCriterion("book_name between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andBookNameNotBetween(String value1, String value2) {
            addCriterion("book_name not between", value1, value2, "bookName");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNull() {
            addCriterion("count_num is null");
            return (Criteria) this;
        }

        public Criteria andCountNumIsNotNull() {
            addCriterion("count_num is not null");
            return (Criteria) this;
        }

        public Criteria andCountNumEqualTo(Integer value) {
            addCriterion("count_num =", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotEqualTo(Integer value) {
            addCriterion("count_num <>", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThan(Integer value) {
            addCriterion("count_num >", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("count_num >=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThan(Integer value) {
            addCriterion("count_num <", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumLessThanOrEqualTo(Integer value) {
            addCriterion("count_num <=", value, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumIn(List<Integer> values) {
            addCriterion("count_num in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotIn(List<Integer> values) {
            addCriterion("count_num not in", values, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumBetween(Integer value1, Integer value2) {
            addCriterion("count_num between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andCountNumNotBetween(Integer value1, Integer value2) {
            addCriterion("count_num not between", value1, value2, "countNum");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyIsNull() {
            addCriterion("only_money is null");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyIsNotNull() {
            addCriterion("only_money is not null");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyEqualTo(Integer value) {
            addCriterion("only_money =", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyNotEqualTo(Integer value) {
            addCriterion("only_money <>", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyGreaterThan(Integer value) {
            addCriterion("only_money >", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyGreaterThanOrEqualTo(Integer value) {
            addCriterion("only_money >=", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyLessThan(Integer value) {
            addCriterion("only_money <", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyLessThanOrEqualTo(Integer value) {
            addCriterion("only_money <=", value, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyIn(List<Integer> values) {
            addCriterion("only_money in", values, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyNotIn(List<Integer> values) {
            addCriterion("only_money not in", values, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyBetween(Integer value1, Integer value2) {
            addCriterion("only_money between", value1, value2, "onlyMoney");
            return (Criteria) this;
        }

        public Criteria andOnlyMoneyNotBetween(Integer value1, Integer value2) {
            addCriterion("only_money not between", value1, value2, "onlyMoney");
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