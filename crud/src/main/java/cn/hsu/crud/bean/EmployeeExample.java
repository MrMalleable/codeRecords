//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.hsu.crud.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;
    protected boolean distinct;
    protected List<EmployeeExample.Criteria> oredCriteria = new ArrayList();

    public EmployeeExample() {
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

    public List<EmployeeExample.Criteria> getOredCriteria() {
        return this.oredCriteria;
    }

    public void or(EmployeeExample.Criteria criteria) {
        this.oredCriteria.add(criteria);
    }

    public EmployeeExample.Criteria or() {
        EmployeeExample.Criteria criteria = this.createCriteriaInternal();
        this.oredCriteria.add(criteria);
        return criteria;
    }

    public EmployeeExample.Criteria createCriteria() {
        EmployeeExample.Criteria criteria = this.createCriteriaInternal();
        if (this.oredCriteria.size() == 0) {
            this.oredCriteria.add(criteria);
        }

        return criteria;
    }

    protected EmployeeExample.Criteria createCriteriaInternal() {
        EmployeeExample.Criteria criteria = new EmployeeExample.Criteria();
        return criteria;
    }

    public void clear() {
        this.oredCriteria.clear();
        this.orderByClause = null;
        this.distinct = false;
    }

    public static class Criteria extends EmployeeExample.GeneratedCriteria {
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
        protected List<EmployeeExample.Criterion> criteria = new ArrayList();

        protected GeneratedCriteria() {
        }

        public boolean isValid() {
            return this.criteria.size() > 0;
        }

        public List<EmployeeExample.Criterion> getAllCriteria() {
            return this.criteria;
        }

        public List<EmployeeExample.Criterion> getCriteria() {
            return this.criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            } else {
                this.criteria.add(new EmployeeExample.Criterion(condition));
            }
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            } else {
                this.criteria.add(new EmployeeExample.Criterion(condition, value));
            }
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 != null && value2 != null) {
                this.criteria.add(new EmployeeExample.Criterion(condition, value1, value2));
            } else {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
        }

        public EmployeeExample.Criteria andEmpIdIsNull() {
            this.addCriterion("emp_id is null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdIsNotNull() {
            this.addCriterion("emp_id is not null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdEqualTo(Integer value) {
            this.addCriterion("emp_id =", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdNotEqualTo(Integer value) {
            this.addCriterion("emp_id <>", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdGreaterThan(Integer value) {
            this.addCriterion("emp_id >", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("emp_id >=", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdLessThan(Integer value) {
            this.addCriterion("emp_id <", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("emp_id <=", value, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdIn(List<Integer> values) {
            this.addCriterion("emp_id in", values, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdNotIn(List<Integer> values) {
            this.addCriterion("emp_id not in", values, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdBetween(Integer value1, Integer value2) {
            this.addCriterion("emp_id between", value1, value2, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("emp_id not between", value1, value2, "empId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameIsNull() {
            this.addCriterion("emp_name is null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameIsNotNull() {
            this.addCriterion("emp_name is not null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameEqualTo(String value) {
            this.addCriterion("emp_name =", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameNotEqualTo(String value) {
            this.addCriterion("emp_name <>", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameGreaterThan(String value) {
            this.addCriterion("emp_name >", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            this.addCriterion("emp_name >=", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameLessThan(String value) {
            this.addCriterion("emp_name <", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameLessThanOrEqualTo(String value) {
            this.addCriterion("emp_name <=", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameLike(String value) {
            this.addCriterion("emp_name like", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameNotLike(String value) {
            this.addCriterion("emp_name not like", value, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameIn(List<String> values) {
            this.addCriterion("emp_name in", values, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameNotIn(List<String> values) {
            this.addCriterion("emp_name not in", values, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameBetween(String value1, String value2) {
            this.addCriterion("emp_name between", value1, value2, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmpNameNotBetween(String value1, String value2) {
            this.addCriterion("emp_name not between", value1, value2, "empName");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderIsNull() {
            this.addCriterion("gender is null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderIsNotNull() {
            this.addCriterion("gender is not null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderEqualTo(String value) {
            this.addCriterion("gender =", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderNotEqualTo(String value) {
            this.addCriterion("gender <>", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderGreaterThan(String value) {
            this.addCriterion("gender >", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderGreaterThanOrEqualTo(String value) {
            this.addCriterion("gender >=", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderLessThan(String value) {
            this.addCriterion("gender <", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderLessThanOrEqualTo(String value) {
            this.addCriterion("gender <=", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderLike(String value) {
            this.addCriterion("gender like", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderNotLike(String value) {
            this.addCriterion("gender not like", value, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderIn(List<String> values) {
            this.addCriterion("gender in", values, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderNotIn(List<String> values) {
            this.addCriterion("gender not in", values, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderBetween(String value1, String value2) {
            this.addCriterion("gender between", value1, value2, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andGenderNotBetween(String value1, String value2) {
            this.addCriterion("gender not between", value1, value2, "gender");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailIsNull() {
            this.addCriterion("email is null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailIsNotNull() {
            this.addCriterion("email is not null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailEqualTo(String value) {
            this.addCriterion("email =", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailNotEqualTo(String value) {
            this.addCriterion("email <>", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailGreaterThan(String value) {
            this.addCriterion("email >", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailGreaterThanOrEqualTo(String value) {
            this.addCriterion("email >=", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailLessThan(String value) {
            this.addCriterion("email <", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailLessThanOrEqualTo(String value) {
            this.addCriterion("email <=", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailLike(String value) {
            this.addCriterion("email like", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailNotLike(String value) {
            this.addCriterion("email not like", value, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailIn(List<String> values) {
            this.addCriterion("email in", values, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailNotIn(List<String> values) {
            this.addCriterion("email not in", values, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailBetween(String value1, String value2) {
            this.addCriterion("email between", value1, value2, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andEmailNotBetween(String value1, String value2) {
            this.addCriterion("email not between", value1, value2, "email");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdIsNull() {
            this.addCriterion("d_id is null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdIsNotNull() {
            this.addCriterion("d_id is not null");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdEqualTo(Integer value) {
            this.addCriterion("d_id =", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdNotEqualTo(Integer value) {
            this.addCriterion("d_id <>", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdGreaterThan(Integer value) {
            this.addCriterion("d_id >", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdGreaterThanOrEqualTo(Integer value) {
            this.addCriterion("d_id >=", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdLessThan(Integer value) {
            this.addCriterion("d_id <", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdLessThanOrEqualTo(Integer value) {
            this.addCriterion("d_id <=", value, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdIn(List<Integer> values) {
            this.addCriterion("d_id in", values, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdNotIn(List<Integer> values) {
            this.addCriterion("d_id not in", values, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdBetween(Integer value1, Integer value2) {
            this.addCriterion("d_id between", value1, value2, "dId");
            return (EmployeeExample.Criteria)this;
        }

        public EmployeeExample.Criteria andDIdNotBetween(Integer value1, Integer value2) {
            this.addCriterion("d_id not between", value1, value2, "dId");
            return (EmployeeExample.Criteria)this;
        }
    }
}
