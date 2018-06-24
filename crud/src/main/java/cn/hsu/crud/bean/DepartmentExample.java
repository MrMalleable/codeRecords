//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class DepartmentExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<DepartmentExample.Criteria> oredCriteria = new ArrayList();

    public DepartmentExample() {
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return this.orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return this.distinct;
    }

    public List<DepartmentExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(DepartmentExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public DepartmentExample.Criteria or() {
        DepartmentExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public DepartmentExample.Criteria createCriteria() {
        DepartmentExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected DepartmentExample.Criteria createCriteriaInternal() {
        DepartmentExample.Criteria criteria = new DepartmentExample.Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static class Criteria extends DepartmentExample.GeneratedCriteria {
        protected Criteria() {
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
            return this.condition;
        }

        public Object getValue() {
            return this.value;
        }

        public Object getSecondValue() {
            return this.secondValue;
        }

        public boolean isNoValue() {
            return this.noValue;
        }

        public boolean isSingleValue() {
            return this.singleValue;
        }

        public boolean isBetweenValue() {
            return this.betweenValue;
        }

        public boolean isListValue() {
            return this.listValue;
        }

        public String getTypeHandler() {
            return this.typeHandler;
        }

        protected Criterion(String condition) {
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }

        }

        protected Criterion(String condition, Object value) {
            this(condition, value, (String)null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, (String)null);
        }
    }

    protected abstract static class GeneratedCriteria {
        protected List<DepartmentExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<DepartmentExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<DepartmentExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new DepartmentExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new DepartmentExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                this.criteria.add(new DepartmentExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public DepartmentExample.Criteria andDeptIdIsNull() {
            this.addCriterion("dept_id is null");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdIsNotNull() {
            this.addCriterion("dept_id is not null");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdEqualTo(Integer value) {
            this.addCriterion("dept_id =", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdNotEqualTo(Integer value) {
            this.addCriterion("dept_id <>", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdGreaterThan(Integer value) {
            this.addCriterion("dept_id >", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("dept_id >=", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdLessThan(Integer value) {
            this.addCriterion("dept_id <", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("dept_id <=", value, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdIn(List<Integer> values) {
            this.addCriterion("dept_id in", values, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdNotIn(List<Integer> values) {
            this.addCriterion("dept_id not in", values, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdBetween(Integer value1, Integer value2) {
            this.addCriterion("dept_id between", value1, value2, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("dept_id not between", value1, value2, "deptId");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameIsNull() {
            this.addCriterion("dept_name is null");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameIsNotNull() {
            this.addCriterion("dept_name is not null");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameEqualTo(String value) {
            this.addCriterion("dept_name =", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameNotEqualTo(String value) {
            this.addCriterion("dept_name <>", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameGreaterThan(String value) {
            this.addCriterion("dept_name >", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("dept_name >=", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameLessThan(String value) {
            this.addCriterion("dept_name <", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameLessThanOrEqualTo(String value) {
            this.addCriterion("dept_name <=", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameLike(String value) {
            this.addCriterion("dept_name like", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameNotLike(String value) {
            this.addCriterion("dept_name not like", value, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameIn(List<String> values) {
            this.addCriterion("dept_name in", values, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameNotIn(List<String> values) {
            this.addCriterion("dept_name not in", values, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameBetween(String value1, String value2) {
            this.addCriterion("dept_name between", value1, value2, "deptName");
            return (DepartmentExample.Criteria)this;
        }

        public DepartmentExample.Criteria andDeptNameNotBetween(String value1, String value2) {
            this.addCriterion("dept_name not between", value1, value2, "deptName");
            return (DepartmentExample.Criteria)this;
        }
    }
}
