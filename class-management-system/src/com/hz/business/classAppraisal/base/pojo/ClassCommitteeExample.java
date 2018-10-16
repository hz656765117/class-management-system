package com.hz.business.classAppraisal.base.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ClassCommitteeExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public ClassCommitteeExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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
			addCriterion("student_key not between", value1, value2,
					"studentKey");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeIsNull() {
			addCriterion("banwei_code is null");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeIsNotNull() {
			addCriterion("banwei_code is not null");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeEqualTo(String value) {
			addCriterion("banwei_code =", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeNotEqualTo(String value) {
			addCriterion("banwei_code <>", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeGreaterThan(String value) {
			addCriterion("banwei_code >", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeGreaterThanOrEqualTo(String value) {
			addCriterion("banwei_code >=", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeLessThan(String value) {
			addCriterion("banwei_code <", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeLessThanOrEqualTo(String value) {
			addCriterion("banwei_code <=", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeLike(String value) {
			addCriterion("banwei_code like", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeNotLike(String value) {
			addCriterion("banwei_code not like", value, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeIn(List<String> values) {
			addCriterion("banwei_code in", values, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeNotIn(List<String> values) {
			addCriterion("banwei_code not in", values, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeBetween(String value1, String value2) {
			addCriterion("banwei_code between", value1, value2, "banweiCode");
			return (Criteria) this;
		}

		public Criteria andBanweiCodeNotBetween(String value1, String value2) {
			addCriterion("banwei_code not between", value1, value2,
					"banweiCode");
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
			addCriterion("create_time not between", value1, value2,
					"createTime");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIsNull() {
			addCriterion("delete_flag is null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIsNotNull() {
			addCriterion("delete_flag is not null");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagEqualTo(Integer value) {
			addCriterion("delete_flag =", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotEqualTo(Integer value) {
			addCriterion("delete_flag <>", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagGreaterThan(Integer value) {
			addCriterion("delete_flag >", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagGreaterThanOrEqualTo(Integer value) {
			addCriterion("delete_flag >=", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagLessThan(Integer value) {
			addCriterion("delete_flag <", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagLessThanOrEqualTo(Integer value) {
			addCriterion("delete_flag <=", value, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagIn(List<Integer> values) {
			addCriterion("delete_flag in", values, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotIn(List<Integer> values) {
			addCriterion("delete_flag not in", values, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagBetween(Integer value1, Integer value2) {
			addCriterion("delete_flag between", value1, value2, "deleteFlag");
			return (Criteria) this;
		}

		public Criteria andDeleteFlagNotBetween(Integer value1, Integer value2) {
			addCriterion("delete_flag not between", value1, value2,
					"deleteFlag");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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