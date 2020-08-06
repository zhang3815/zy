package com.xiaoshu.entity;

import java.util.ArrayList;
import java.util.List;

public class DeptExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeptExample() {
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

        public Criteria andDDepidIsNull() {
            addCriterion("d_depid is null");
            return (Criteria) this;
        }

        public Criteria andDDepidIsNotNull() {
            addCriterion("d_depid is not null");
            return (Criteria) this;
        }

        public Criteria andDDepidEqualTo(Integer value) {
            addCriterion("d_depid =", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidNotEqualTo(Integer value) {
            addCriterion("d_depid <>", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidGreaterThan(Integer value) {
            addCriterion("d_depid >", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_depid >=", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidLessThan(Integer value) {
            addCriterion("d_depid <", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidLessThanOrEqualTo(Integer value) {
            addCriterion("d_depid <=", value, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidIn(List<Integer> values) {
            addCriterion("d_depid in", values, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidNotIn(List<Integer> values) {
            addCriterion("d_depid not in", values, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidBetween(Integer value1, Integer value2) {
            addCriterion("d_depid between", value1, value2, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDepidNotBetween(Integer value1, Integer value2) {
            addCriterion("d_depid not between", value1, value2, "dDepid");
            return (Criteria) this;
        }

        public Criteria andDDnameIsNull() {
            addCriterion("d_dname is null");
            return (Criteria) this;
        }

        public Criteria andDDnameIsNotNull() {
            addCriterion("d_dname is not null");
            return (Criteria) this;
        }

        public Criteria andDDnameEqualTo(String value) {
            addCriterion("d_dname =", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameNotEqualTo(String value) {
            addCriterion("d_dname <>", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameGreaterThan(String value) {
            addCriterion("d_dname >", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameGreaterThanOrEqualTo(String value) {
            addCriterion("d_dname >=", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameLessThan(String value) {
            addCriterion("d_dname <", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameLessThanOrEqualTo(String value) {
            addCriterion("d_dname <=", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameLike(String value) {
            addCriterion("d_dname like", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameNotLike(String value) {
            addCriterion("d_dname not like", value, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameIn(List<String> values) {
            addCriterion("d_dname in", values, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameNotIn(List<String> values) {
            addCriterion("d_dname not in", values, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameBetween(String value1, String value2) {
            addCriterion("d_dname between", value1, value2, "dDname");
            return (Criteria) this;
        }

        public Criteria andDDnameNotBetween(String value1, String value2) {
            addCriterion("d_dname not between", value1, value2, "dDname");
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