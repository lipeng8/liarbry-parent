package com.yctu.liarbry.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YctuLiarbryTeachersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YctuLiarbryTeachersExample() {
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

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIsNull() {
            addCriterion("teacher_pwd is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIsNotNull() {
            addCriterion("teacher_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdEqualTo(String value) {
            addCriterion("teacher_pwd =", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotEqualTo(String value) {
            addCriterion("teacher_pwd <>", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdGreaterThan(String value) {
            addCriterion("teacher_pwd >", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_pwd >=", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLessThan(String value) {
            addCriterion("teacher_pwd <", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLessThanOrEqualTo(String value) {
            addCriterion("teacher_pwd <=", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdLike(String value) {
            addCriterion("teacher_pwd like", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotLike(String value) {
            addCriterion("teacher_pwd not like", value, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdIn(List<String> values) {
            addCriterion("teacher_pwd in", values, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotIn(List<String> values) {
            addCriterion("teacher_pwd not in", values, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdBetween(String value1, String value2) {
            addCriterion("teacher_pwd between", value1, value2, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherPwdNotBetween(String value1, String value2) {
            addCriterion("teacher_pwd not between", value1, value2, "teacherPwd");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIsNull() {
            addCriterion("teacher_class is null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIsNotNull() {
            addCriterion("teacher_class is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherClassEqualTo(Integer value) {
            addCriterion("teacher_class =", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotEqualTo(Integer value) {
            addCriterion("teacher_class <>", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassGreaterThan(Integer value) {
            addCriterion("teacher_class >", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_class >=", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassLessThan(Integer value) {
            addCriterion("teacher_class <", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_class <=", value, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassIn(List<Integer> values) {
            addCriterion("teacher_class in", values, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotIn(List<Integer> values) {
            addCriterion("teacher_class not in", values, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassBetween(Integer value1, Integer value2) {
            addCriterion("teacher_class between", value1, value2, "teacherClass");
            return (Criteria) this;
        }

        public Criteria andTeacherClassNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_class not between", value1, value2, "teacherClass");
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

        public Criteria andTeacherBooknbsIsNull() {
            addCriterion("teacher_booknbs is null");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsIsNotNull() {
            addCriterion("teacher_booknbs is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsEqualTo(Integer value) {
            addCriterion("teacher_booknbs =", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsNotEqualTo(Integer value) {
            addCriterion("teacher_booknbs <>", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsGreaterThan(Integer value) {
            addCriterion("teacher_booknbs >", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_booknbs >=", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsLessThan(Integer value) {
            addCriterion("teacher_booknbs <", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_booknbs <=", value, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsIn(List<Integer> values) {
            addCriterion("teacher_booknbs in", values, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsNotIn(List<Integer> values) {
            addCriterion("teacher_booknbs not in", values, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsBetween(Integer value1, Integer value2) {
            addCriterion("teacher_booknbs between", value1, value2, "teacherBooknbs");
            return (Criteria) this;
        }

        public Criteria andTeacherBooknbsNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_booknbs not between", value1, value2, "teacherBooknbs");
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