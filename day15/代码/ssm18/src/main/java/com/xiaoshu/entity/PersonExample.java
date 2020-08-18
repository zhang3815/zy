package com.xiaoshu.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PersonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andPIdIsNull() {
            addCriterion("p_id is null");
            return (Criteria) this;
        }

        public Criteria andPIdIsNotNull() {
            addCriterion("p_id is not null");
            return (Criteria) this;
        }

        public Criteria andPIdEqualTo(Integer value) {
            addCriterion("p_id =", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotEqualTo(Integer value) {
            addCriterion("p_id <>", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThan(Integer value) {
            addCriterion("p_id >", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("p_id >=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThan(Integer value) {
            addCriterion("p_id <", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdLessThanOrEqualTo(Integer value) {
            addCriterion("p_id <=", value, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdIn(List<Integer> values) {
            addCriterion("p_id in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotIn(List<Integer> values) {
            addCriterion("p_id not in", values, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdBetween(Integer value1, Integer value2) {
            addCriterion("p_id between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andPIdNotBetween(Integer value1, Integer value2) {
            addCriterion("p_id not between", value1, value2, "pId");
            return (Criteria) this;
        }

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(Integer value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(Integer value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(Integer value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(Integer value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<Integer> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<Integer> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(Integer value1, Integer value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_id not between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPAgeIsNull() {
            addCriterion("p_age is null");
            return (Criteria) this;
        }

        public Criteria andPAgeIsNotNull() {
            addCriterion("p_age is not null");
            return (Criteria) this;
        }

        public Criteria andPAgeEqualTo(String value) {
            addCriterion("p_age =", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotEqualTo(String value) {
            addCriterion("p_age <>", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeGreaterThan(String value) {
            addCriterion("p_age >", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeGreaterThanOrEqualTo(String value) {
            addCriterion("p_age >=", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLessThan(String value) {
            addCriterion("p_age <", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLessThanOrEqualTo(String value) {
            addCriterion("p_age <=", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeLike(String value) {
            addCriterion("p_age like", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotLike(String value) {
            addCriterion("p_age not like", value, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeIn(List<String> values) {
            addCriterion("p_age in", values, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotIn(List<String> values) {
            addCriterion("p_age not in", values, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeBetween(String value1, String value2) {
            addCriterion("p_age between", value1, value2, "pAge");
            return (Criteria) this;
        }

        public Criteria andPAgeNotBetween(String value1, String value2) {
            addCriterion("p_age not between", value1, value2, "pAge");
            return (Criteria) this;
        }

        public Criteria andPSexIsNull() {
            addCriterion("p_sex is null");
            return (Criteria) this;
        }

        public Criteria andPSexIsNotNull() {
            addCriterion("p_sex is not null");
            return (Criteria) this;
        }

        public Criteria andPSexEqualTo(String value) {
            addCriterion("p_sex =", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotEqualTo(String value) {
            addCriterion("p_sex <>", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexGreaterThan(String value) {
            addCriterion("p_sex >", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexGreaterThanOrEqualTo(String value) {
            addCriterion("p_sex >=", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLessThan(String value) {
            addCriterion("p_sex <", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLessThanOrEqualTo(String value) {
            addCriterion("p_sex <=", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexLike(String value) {
            addCriterion("p_sex like", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotLike(String value) {
            addCriterion("p_sex not like", value, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexIn(List<String> values) {
            addCriterion("p_sex in", values, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotIn(List<String> values) {
            addCriterion("p_sex not in", values, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexBetween(String value1, String value2) {
            addCriterion("p_sex between", value1, value2, "pSex");
            return (Criteria) this;
        }

        public Criteria andPSexNotBetween(String value1, String value2) {
            addCriterion("p_sex not between", value1, value2, "pSex");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPLikeIsNull() {
            addCriterion("p_like is null");
            return (Criteria) this;
        }

        public Criteria andPLikeIsNotNull() {
            addCriterion("p_like is not null");
            return (Criteria) this;
        }

        public Criteria andPLikeEqualTo(String value) {
            addCriterion("p_like =", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeNotEqualTo(String value) {
            addCriterion("p_like <>", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeGreaterThan(String value) {
            addCriterion("p_like >", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeGreaterThanOrEqualTo(String value) {
            addCriterion("p_like >=", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeLessThan(String value) {
            addCriterion("p_like <", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeLessThanOrEqualTo(String value) {
            addCriterion("p_like <=", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeLike(String value) {
            addCriterion("p_like like", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeNotLike(String value) {
            addCriterion("p_like not like", value, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeIn(List<String> values) {
            addCriterion("p_like in", values, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeNotIn(List<String> values) {
            addCriterion("p_like not in", values, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeBetween(String value1, String value2) {
            addCriterion("p_like between", value1, value2, "pLike");
            return (Criteria) this;
        }

        public Criteria andPLikeNotBetween(String value1, String value2) {
            addCriterion("p_like not between", value1, value2, "pLike");
            return (Criteria) this;
        }

        public Criteria andPCountIsNull() {
            addCriterion("p_count is null");
            return (Criteria) this;
        }

        public Criteria andPCountIsNotNull() {
            addCriterion("p_count is not null");
            return (Criteria) this;
        }

        public Criteria andPCountEqualTo(String value) {
            addCriterion("p_count =", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountNotEqualTo(String value) {
            addCriterion("p_count <>", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountGreaterThan(String value) {
            addCriterion("p_count >", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountGreaterThanOrEqualTo(String value) {
            addCriterion("p_count >=", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountLessThan(String value) {
            addCriterion("p_count <", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountLessThanOrEqualTo(String value) {
            addCriterion("p_count <=", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountLike(String value) {
            addCriterion("p_count like", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountNotLike(String value) {
            addCriterion("p_count not like", value, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountIn(List<String> values) {
            addCriterion("p_count in", values, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountNotIn(List<String> values) {
            addCriterion("p_count not in", values, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountBetween(String value1, String value2) {
            addCriterion("p_count between", value1, value2, "pCount");
            return (Criteria) this;
        }

        public Criteria andPCountNotBetween(String value1, String value2) {
            addCriterion("p_count not between", value1, value2, "pCount");
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