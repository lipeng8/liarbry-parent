package com.yctu.liarbry.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YctuLiarbryInExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YctuLiarbryInExample() {
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

        public Criteria andBookIdIsNull() {
            addCriterion("book_id is null");
            return (Criteria) this;
        }

        public Criteria andBookIdIsNotNull() {
            addCriterion("book_id is not null");
            return (Criteria) this;
        }

        public Criteria andBookIdEqualTo(Integer value) {
            addCriterion("book_id =", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotEqualTo(Integer value) {
            addCriterion("book_id <>", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThan(Integer value) {
            addCriterion("book_id >", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("book_id >=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThan(Integer value) {
            addCriterion("book_id <", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdLessThanOrEqualTo(Integer value) {
            addCriterion("book_id <=", value, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdIn(List<Integer> values) {
            addCriterion("book_id in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotIn(List<Integer> values) {
            addCriterion("book_id not in", values, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdBetween(Integer value1, Integer value2) {
            addCriterion("book_id between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andBookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("book_id not between", value1, value2, "bookId");
            return (Criteria) this;
        }

        public Criteria andInStIdIsNull() {
            addCriterion("in_st_id is null");
            return (Criteria) this;
        }

        public Criteria andInStIdIsNotNull() {
            addCriterion("in_st_id is not null");
            return (Criteria) this;
        }

        public Criteria andInStIdEqualTo(Integer value) {
            addCriterion("in_st_id =", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdNotEqualTo(Integer value) {
            addCriterion("in_st_id <>", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdGreaterThan(Integer value) {
            addCriterion("in_st_id >", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_st_id >=", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdLessThan(Integer value) {
            addCriterion("in_st_id <", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_st_id <=", value, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdIn(List<Integer> values) {
            addCriterion("in_st_id in", values, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdNotIn(List<Integer> values) {
            addCriterion("in_st_id not in", values, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdBetween(Integer value1, Integer value2) {
            addCriterion("in_st_id between", value1, value2, "inStId");
            return (Criteria) this;
        }

        public Criteria andInStIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_st_id not between", value1, value2, "inStId");
            return (Criteria) this;
        }

        public Criteria andInOpIdIsNull() {
            addCriterion("in_op_id is null");
            return (Criteria) this;
        }

        public Criteria andInOpIdIsNotNull() {
            addCriterion("in_op_id is not null");
            return (Criteria) this;
        }

        public Criteria andInOpIdEqualTo(Integer value) {
            addCriterion("in_op_id =", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdNotEqualTo(Integer value) {
            addCriterion("in_op_id <>", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdGreaterThan(Integer value) {
            addCriterion("in_op_id >", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_op_id >=", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdLessThan(Integer value) {
            addCriterion("in_op_id <", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdLessThanOrEqualTo(Integer value) {
            addCriterion("in_op_id <=", value, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdIn(List<Integer> values) {
            addCriterion("in_op_id in", values, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdNotIn(List<Integer> values) {
            addCriterion("in_op_id not in", values, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdBetween(Integer value1, Integer value2) {
            addCriterion("in_op_id between", value1, value2, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInOpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("in_op_id not between", value1, value2, "inOpId");
            return (Criteria) this;
        }

        public Criteria andInStausIsNull() {
            addCriterion("in_staus is null");
            return (Criteria) this;
        }

        public Criteria andInStausIsNotNull() {
            addCriterion("in_staus is not null");
            return (Criteria) this;
        }

        public Criteria andInStausEqualTo(Integer value) {
            addCriterion("in_staus =", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausNotEqualTo(Integer value) {
            addCriterion("in_staus <>", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausGreaterThan(Integer value) {
            addCriterion("in_staus >", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausGreaterThanOrEqualTo(Integer value) {
            addCriterion("in_staus >=", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausLessThan(Integer value) {
            addCriterion("in_staus <", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausLessThanOrEqualTo(Integer value) {
            addCriterion("in_staus <=", value, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausIn(List<Integer> values) {
            addCriterion("in_staus in", values, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausNotIn(List<Integer> values) {
            addCriterion("in_staus not in", values, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausBetween(Integer value1, Integer value2) {
            addCriterion("in_staus between", value1, value2, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInStausNotBetween(Integer value1, Integer value2) {
            addCriterion("in_staus not between", value1, value2, "inStaus");
            return (Criteria) this;
        }

        public Criteria andInDateIsNull() {
            addCriterion("in_date is null");
            return (Criteria) this;
        }

        public Criteria andInDateIsNotNull() {
            addCriterion("in_date is not null");
            return (Criteria) this;
        }

        public Criteria andInDateEqualTo(String value) {
            addCriterion("in_date =", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotEqualTo(String value) {
            addCriterion("in_date <>", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThan(String value) {
            addCriterion("in_date >", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateGreaterThanOrEqualTo(String value) {
            addCriterion("in_date >=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThan(String value) {
            addCriterion("in_date <", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLessThanOrEqualTo(String value) {
            addCriterion("in_date <=", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateLike(String value) {
            addCriterion("in_date like", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotLike(String value) {
            addCriterion("in_date not like", value, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateIn(List<String> values) {
            addCriterion("in_date in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotIn(List<String> values) {
            addCriterion("in_date not in", values, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateBetween(String value1, String value2) {
            addCriterion("in_date between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andInDateNotBetween(String value1, String value2) {
            addCriterion("in_date not between", value1, value2, "inDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt2IsNull() {
            addCriterion("ext2 is null");
            return (Criteria) this;
        }

        public Criteria andExt2IsNotNull() {
            addCriterion("ext2 is not null");
            return (Criteria) this;
        }

        public Criteria andExt2EqualTo(String value) {
            addCriterion("ext2 =", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotEqualTo(String value) {
            addCriterion("ext2 <>", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThan(String value) {
            addCriterion("ext2 >", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2GreaterThanOrEqualTo(String value) {
            addCriterion("ext2 >=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThan(String value) {
            addCriterion("ext2 <", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2LessThanOrEqualTo(String value) {
            addCriterion("ext2 <=", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Like(String value) {
            addCriterion("ext2 like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotLike(String value) {
            addCriterion("ext2 not like", value, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2In(List<String> values) {
            addCriterion("ext2 in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotIn(List<String> values) {
            addCriterion("ext2 not in", values, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2Between(String value1, String value2) {
            addCriterion("ext2 between", value1, value2, "ext2");
            return (Criteria) this;
        }

        public Criteria andExt2NotBetween(String value1, String value2) {
            addCriterion("ext2 not between", value1, value2, "ext2");
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