package com.entity;

import java.util.ArrayList;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
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

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andContectIsNull() {
            addCriterion("contect is null");
            return (Criteria) this;
        }

        public Criteria andContectIsNotNull() {
            addCriterion("contect is not null");
            return (Criteria) this;
        }

        public Criteria andContectEqualTo(String value) {
            addCriterion("contect =", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectNotEqualTo(String value) {
            addCriterion("contect <>", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectGreaterThan(String value) {
            addCriterion("contect >", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectGreaterThanOrEqualTo(String value) {
            addCriterion("contect >=", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectLessThan(String value) {
            addCriterion("contect <", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectLessThanOrEqualTo(String value) {
            addCriterion("contect <=", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectLike(String value) {
            addCriterion("contect like", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectNotLike(String value) {
            addCriterion("contect not like", value, "contect");
            return (Criteria) this;
        }

        public Criteria andContectIn(List<String> values) {
            addCriterion("contect in", values, "contect");
            return (Criteria) this;
        }

        public Criteria andContectNotIn(List<String> values) {
            addCriterion("contect not in", values, "contect");
            return (Criteria) this;
        }

        public Criteria andContectBetween(String value1, String value2) {
            addCriterion("contect between", value1, value2, "contect");
            return (Criteria) this;
        }

        public Criteria andContectNotBetween(String value1, String value2) {
            addCriterion("contect not between", value1, value2, "contect");
            return (Criteria) this;
        }

        public Criteria andFromtoIsNull() {
            addCriterion("fromto is null");
            return (Criteria) this;
        }

        public Criteria andFromtoIsNotNull() {
            addCriterion("fromto is not null");
            return (Criteria) this;
        }

        public Criteria andFromtoEqualTo(String value) {
            addCriterion("fromto =", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoNotEqualTo(String value) {
            addCriterion("fromto <>", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoGreaterThan(String value) {
            addCriterion("fromto >", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoGreaterThanOrEqualTo(String value) {
            addCriterion("fromto >=", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoLessThan(String value) {
            addCriterion("fromto <", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoLessThanOrEqualTo(String value) {
            addCriterion("fromto <=", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoLike(String value) {
            addCriterion("fromto like", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoNotLike(String value) {
            addCriterion("fromto not like", value, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoIn(List<String> values) {
            addCriterion("fromto in", values, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoNotIn(List<String> values) {
            addCriterion("fromto not in", values, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoBetween(String value1, String value2) {
            addCriterion("fromto between", value1, value2, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromtoNotBetween(String value1, String value2) {
            addCriterion("fromto not between", value1, value2, "fromto");
            return (Criteria) this;
        }

        public Criteria andFromuserIsNull() {
            addCriterion("fromuser is null");
            return (Criteria) this;
        }

        public Criteria andFromuserIsNotNull() {
            addCriterion("fromuser is not null");
            return (Criteria) this;
        }

        public Criteria andFromuserEqualTo(String value) {
            addCriterion("fromuser =", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotEqualTo(String value) {
            addCriterion("fromuser <>", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThan(String value) {
            addCriterion("fromuser >", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserGreaterThanOrEqualTo(String value) {
            addCriterion("fromuser >=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThan(String value) {
            addCriterion("fromuser <", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLessThanOrEqualTo(String value) {
            addCriterion("fromuser <=", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserLike(String value) {
            addCriterion("fromuser like", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotLike(String value) {
            addCriterion("fromuser not like", value, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserIn(List<String> values) {
            addCriterion("fromuser in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotIn(List<String> values) {
            addCriterion("fromuser not in", values, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserBetween(String value1, String value2) {
            addCriterion("fromuser between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andFromuserNotBetween(String value1, String value2) {
            addCriterion("fromuser not between", value1, value2, "fromuser");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNull() {
            addCriterion("isdelete is null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIsNotNull() {
            addCriterion("isdelete is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeleteEqualTo(Integer value) {
            addCriterion("isdelete =", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotEqualTo(Integer value) {
            addCriterion("isdelete <>", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThan(Integer value) {
            addCriterion("isdelete >", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdelete >=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThan(Integer value) {
            addCriterion("isdelete <", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteLessThanOrEqualTo(Integer value) {
            addCriterion("isdelete <=", value, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteIn(List<Integer> values) {
            addCriterion("isdelete in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotIn(List<Integer> values) {
            addCriterion("isdelete not in", values, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteBetween(Integer value1, Integer value2) {
            addCriterion("isdelete between", value1, value2, "isdelete");
            return (Criteria) this;
        }

        public Criteria andIsdeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("isdelete not between", value1, value2, "isdelete");
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