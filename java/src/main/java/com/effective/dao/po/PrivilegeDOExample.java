package com.effective.dao.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrivilegeDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public PrivilegeDOExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidIsNull() {
            addCriterion("privilege_uuid is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidIsNotNull() {
            addCriterion("privilege_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidEqualTo(String value) {
            addCriterion("privilege_uuid =", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidNotEqualTo(String value) {
            addCriterion("privilege_uuid <>", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidGreaterThan(String value) {
            addCriterion("privilege_uuid >", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("privilege_uuid >=", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidLessThan(String value) {
            addCriterion("privilege_uuid <", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidLessThanOrEqualTo(String value) {
            addCriterion("privilege_uuid <=", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidLike(String value) {
            addCriterion("privilege_uuid like", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidNotLike(String value) {
            addCriterion("privilege_uuid not like", value, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidIn(List<String> values) {
            addCriterion("privilege_uuid in", values, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidNotIn(List<String> values) {
            addCriterion("privilege_uuid not in", values, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidBetween(String value1, String value2) {
            addCriterion("privilege_uuid between", value1, value2, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeUuidNotBetween(String value1, String value2) {
            addCriterion("privilege_uuid not between", value1, value2, "privilegeUuid");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameIsNull() {
            addCriterion("privilege_name is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameIsNotNull() {
            addCriterion("privilege_name is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameEqualTo(String value) {
            addCriterion("privilege_name =", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotEqualTo(String value) {
            addCriterion("privilege_name <>", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameGreaterThan(String value) {
            addCriterion("privilege_name >", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameGreaterThanOrEqualTo(String value) {
            addCriterion("privilege_name >=", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLessThan(String value) {
            addCriterion("privilege_name <", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLessThanOrEqualTo(String value) {
            addCriterion("privilege_name <=", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameLike(String value) {
            addCriterion("privilege_name like", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotLike(String value) {
            addCriterion("privilege_name not like", value, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameIn(List<String> values) {
            addCriterion("privilege_name in", values, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotIn(List<String> values) {
            addCriterion("privilege_name not in", values, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameBetween(String value1, String value2) {
            addCriterion("privilege_name between", value1, value2, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeNameNotBetween(String value1, String value2) {
            addCriterion("privilege_name not between", value1, value2, "privilegeName");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortIsNull() {
            addCriterion("privilege_sort is null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortIsNotNull() {
            addCriterion("privilege_sort is not null");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortEqualTo(Integer value) {
            addCriterion("privilege_sort =", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortNotEqualTo(Integer value) {
            addCriterion("privilege_sort <>", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortGreaterThan(Integer value) {
            addCriterion("privilege_sort >", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("privilege_sort >=", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortLessThan(Integer value) {
            addCriterion("privilege_sort <", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortLessThanOrEqualTo(Integer value) {
            addCriterion("privilege_sort <=", value, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortIn(List<Integer> values) {
            addCriterion("privilege_sort in", values, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortNotIn(List<Integer> values) {
            addCriterion("privilege_sort not in", values, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortBetween(Integer value1, Integer value2) {
            addCriterion("privilege_sort between", value1, value2, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andPrivilegeSortNotBetween(Integer value1, Integer value2) {
            addCriterion("privilege_sort not between", value1, value2, "privilegeSort");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidIsNull() {
            addCriterion("parent_privilege_uuid is null");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidIsNotNull() {
            addCriterion("parent_privilege_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidEqualTo(String value) {
            addCriterion("parent_privilege_uuid =", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidNotEqualTo(String value) {
            addCriterion("parent_privilege_uuid <>", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidGreaterThan(String value) {
            addCriterion("parent_privilege_uuid >", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidGreaterThanOrEqualTo(String value) {
            addCriterion("parent_privilege_uuid >=", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidLessThan(String value) {
            addCriterion("parent_privilege_uuid <", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidLessThanOrEqualTo(String value) {
            addCriterion("parent_privilege_uuid <=", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidLike(String value) {
            addCriterion("parent_privilege_uuid like", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidNotLike(String value) {
            addCriterion("parent_privilege_uuid not like", value, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidIn(List<String> values) {
            addCriterion("parent_privilege_uuid in", values, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidNotIn(List<String> values) {
            addCriterion("parent_privilege_uuid not in", values, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidBetween(String value1, String value2) {
            addCriterion("parent_privilege_uuid between", value1, value2, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andParentPrivilegeUuidNotBetween(String value1, String value2) {
            addCriterion("parent_privilege_uuid not between", value1, value2, "parentPrivilegeUuid");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNull() {
            addCriterion("is_menu is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNotNull() {
            addCriterion("is_menu is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuEqualTo(Boolean value) {
            addCriterion("is_menu =", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotEqualTo(Boolean value) {
            addCriterion("is_menu <>", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThan(Boolean value) {
            addCriterion("is_menu >", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_menu >=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThan(Boolean value) {
            addCriterion("is_menu <", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThanOrEqualTo(Boolean value) {
            addCriterion("is_menu <=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuIn(List<Boolean> values) {
            addCriterion("is_menu in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotIn(List<Boolean> values) {
            addCriterion("is_menu not in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuBetween(Boolean value1, Boolean value2) {
            addCriterion("is_menu between", value1, value2, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_menu not between", value1, value2, "isMenu");
            return (Criteria) this;
        }

        public Criteria andRouteIsNull() {
            addCriterion("route is null");
            return (Criteria) this;
        }

        public Criteria andRouteIsNotNull() {
            addCriterion("route is not null");
            return (Criteria) this;
        }

        public Criteria andRouteEqualTo(String value) {
            addCriterion("route =", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotEqualTo(String value) {
            addCriterion("route <>", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteGreaterThan(String value) {
            addCriterion("route >", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteGreaterThanOrEqualTo(String value) {
            addCriterion("route >=", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLessThan(String value) {
            addCriterion("route <", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLessThanOrEqualTo(String value) {
            addCriterion("route <=", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteLike(String value) {
            addCriterion("route like", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotLike(String value) {
            addCriterion("route not like", value, "route");
            return (Criteria) this;
        }

        public Criteria andRouteIn(List<String> values) {
            addCriterion("route in", values, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotIn(List<String> values) {
            addCriterion("route not in", values, "route");
            return (Criteria) this;
        }

        public Criteria andRouteBetween(String value1, String value2) {
            addCriterion("route between", value1, value2, "route");
            return (Criteria) this;
        }

        public Criteria andRouteNotBetween(String value1, String value2) {
            addCriterion("route not between", value1, value2, "route");
            return (Criteria) this;
        }

        public Criteria andIconIsNull() {
            addCriterion("icon is null");
            return (Criteria) this;
        }

        public Criteria andIconIsNotNull() {
            addCriterion("icon is not null");
            return (Criteria) this;
        }

        public Criteria andIconEqualTo(String value) {
            addCriterion("icon =", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotEqualTo(String value) {
            addCriterion("icon <>", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThan(String value) {
            addCriterion("icon >", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconGreaterThanOrEqualTo(String value) {
            addCriterion("icon >=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThan(String value) {
            addCriterion("icon <", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLessThanOrEqualTo(String value) {
            addCriterion("icon <=", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconLike(String value) {
            addCriterion("icon like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotLike(String value) {
            addCriterion("icon not like", value, "icon");
            return (Criteria) this;
        }

        public Criteria andIconIn(List<String> values) {
            addCriterion("icon in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotIn(List<String> values) {
            addCriterion("icon not in", values, "icon");
            return (Criteria) this;
        }

        public Criteria andIconBetween(String value1, String value2) {
            addCriterion("icon between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andIconNotBetween(String value1, String value2) {
            addCriterion("icon not between", value1, value2, "icon");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
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