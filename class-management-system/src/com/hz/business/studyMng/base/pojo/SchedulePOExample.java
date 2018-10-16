package com.hz.business.studyMng.base.pojo;

import java.util.ArrayList;
import java.util.List;

public class SchedulePOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SchedulePOExample() {
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

        public Criteria andScheduleKeyIsNull() {
            addCriterion("schedule_key is null");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyIsNotNull() {
            addCriterion("schedule_key is not null");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyEqualTo(String value) {
            addCriterion("schedule_key =", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyNotEqualTo(String value) {
            addCriterion("schedule_key <>", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyGreaterThan(String value) {
            addCriterion("schedule_key >", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyGreaterThanOrEqualTo(String value) {
            addCriterion("schedule_key >=", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyLessThan(String value) {
            addCriterion("schedule_key <", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyLessThanOrEqualTo(String value) {
            addCriterion("schedule_key <=", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyLike(String value) {
            addCriterion("schedule_key like", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyNotLike(String value) {
            addCriterion("schedule_key not like", value, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyIn(List<String> values) {
            addCriterion("schedule_key in", values, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyNotIn(List<String> values) {
            addCriterion("schedule_key not in", values, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyBetween(String value1, String value2) {
            addCriterion("schedule_key between", value1, value2, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andScheduleKeyNotBetween(String value1, String value2) {
            addCriterion("schedule_key not between", value1, value2, "scheduleKey");
            return (Criteria) this;
        }

        public Criteria andWeekSeqIsNull() {
            addCriterion("week_Seq is null");
            return (Criteria) this;
        }

        public Criteria andWeekSeqIsNotNull() {
            addCriterion("week_Seq is not null");
            return (Criteria) this;
        }

        public Criteria andWeekSeqEqualTo(Integer value) {
            addCriterion("week_Seq =", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqNotEqualTo(Integer value) {
            addCriterion("week_Seq <>", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqGreaterThan(Integer value) {
            addCriterion("week_Seq >", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_Seq >=", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqLessThan(Integer value) {
            addCriterion("week_Seq <", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqLessThanOrEqualTo(Integer value) {
            addCriterion("week_Seq <=", value, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqIn(List<Integer> values) {
            addCriterion("week_Seq in", values, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqNotIn(List<Integer> values) {
            addCriterion("week_Seq not in", values, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqBetween(Integer value1, Integer value2) {
            addCriterion("week_Seq between", value1, value2, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andWeekSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("week_Seq not between", value1, value2, "weekSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNull() {
            addCriterion("order_Seq is null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIsNotNull() {
            addCriterion("order_Seq is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSeqEqualTo(Integer value) {
            addCriterion("order_Seq =", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotEqualTo(Integer value) {
            addCriterion("order_Seq <>", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThan(Integer value) {
            addCriterion("order_Seq >", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_Seq >=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThan(Integer value) {
            addCriterion("order_Seq <", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqLessThanOrEqualTo(Integer value) {
            addCriterion("order_Seq <=", value, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqIn(List<Integer> values) {
            addCriterion("order_Seq in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotIn(List<Integer> values) {
            addCriterion("order_Seq not in", values, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqBetween(Integer value1, Integer value2) {
            addCriterion("order_Seq between", value1, value2, "orderSeq");
            return (Criteria) this;
        }

        public Criteria andOrderSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("order_Seq not between", value1, value2, "orderSeq");
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

        public Criteria andClassCourseIdIsNull() {
            addCriterion("class_course_id is null");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdIsNotNull() {
            addCriterion("class_course_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdEqualTo(Integer value) {
            addCriterion("class_course_id =", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdNotEqualTo(Integer value) {
            addCriterion("class_course_id <>", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdGreaterThan(Integer value) {
            addCriterion("class_course_id >", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_course_id >=", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdLessThan(Integer value) {
            addCriterion("class_course_id <", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_course_id <=", value, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdIn(List<Integer> values) {
            addCriterion("class_course_id in", values, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdNotIn(List<Integer> values) {
            addCriterion("class_course_id not in", values, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("class_course_id between", value1, value2, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andClassCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_course_id not between", value1, value2, "classCourseId");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqIsNull() {
            addCriterion("start_week_seq is null");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqIsNotNull() {
            addCriterion("start_week_seq is not null");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqEqualTo(Integer value) {
            addCriterion("start_week_seq =", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqNotEqualTo(Integer value) {
            addCriterion("start_week_seq <>", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqGreaterThan(Integer value) {
            addCriterion("start_week_seq >", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("start_week_seq >=", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqLessThan(Integer value) {
            addCriterion("start_week_seq <", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqLessThanOrEqualTo(Integer value) {
            addCriterion("start_week_seq <=", value, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqIn(List<Integer> values) {
            addCriterion("start_week_seq in", values, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqNotIn(List<Integer> values) {
            addCriterion("start_week_seq not in", values, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqBetween(Integer value1, Integer value2) {
            addCriterion("start_week_seq between", value1, value2, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andStartWeekSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("start_week_seq not between", value1, value2, "startWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqIsNull() {
            addCriterion("end_week_seq is null");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqIsNotNull() {
            addCriterion("end_week_seq is not null");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqEqualTo(Integer value) {
            addCriterion("end_week_seq =", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqNotEqualTo(Integer value) {
            addCriterion("end_week_seq <>", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqGreaterThan(Integer value) {
            addCriterion("end_week_seq >", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_week_seq >=", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqLessThan(Integer value) {
            addCriterion("end_week_seq <", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqLessThanOrEqualTo(Integer value) {
            addCriterion("end_week_seq <=", value, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqIn(List<Integer> values) {
            addCriterion("end_week_seq in", values, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqNotIn(List<Integer> values) {
            addCriterion("end_week_seq not in", values, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqBetween(Integer value1, Integer value2) {
            addCriterion("end_week_seq between", value1, value2, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andEndWeekSeqNotBetween(Integer value1, Integer value2) {
            addCriterion("end_week_seq not between", value1, value2, "endWeekSeq");
            return (Criteria) this;
        }

        public Criteria andClassKeyIsNull() {
            addCriterion("class_key is null");
            return (Criteria) this;
        }

        public Criteria andClassKeyIsNotNull() {
            addCriterion("class_key is not null");
            return (Criteria) this;
        }

        public Criteria andClassKeyEqualTo(String value) {
            addCriterion("class_key =", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyNotEqualTo(String value) {
            addCriterion("class_key <>", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyGreaterThan(String value) {
            addCriterion("class_key >", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyGreaterThanOrEqualTo(String value) {
            addCriterion("class_key >=", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyLessThan(String value) {
            addCriterion("class_key <", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyLessThanOrEqualTo(String value) {
            addCriterion("class_key <=", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyLike(String value) {
            addCriterion("class_key like", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyNotLike(String value) {
            addCriterion("class_key not like", value, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyIn(List<String> values) {
            addCriterion("class_key in", values, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyNotIn(List<String> values) {
            addCriterion("class_key not in", values, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyBetween(String value1, String value2) {
            addCriterion("class_key between", value1, value2, "classKey");
            return (Criteria) this;
        }

        public Criteria andClassKeyNotBetween(String value1, String value2) {
            addCriterion("class_key not between", value1, value2, "classKey");
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