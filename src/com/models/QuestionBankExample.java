package com.models;

import java.util.ArrayList;
import java.util.List;

public class QuestionBankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QuestionBankExample() {
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

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Integer value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Integer value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Integer value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Integer value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Integer> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Integer> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Integer value1, Integer value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andOptionOneIsNull() {
            addCriterion("option_one is null");
            return (Criteria) this;
        }

        public Criteria andOptionOneIsNotNull() {
            addCriterion("option_one is not null");
            return (Criteria) this;
        }

        public Criteria andOptionOneEqualTo(String value) {
            addCriterion("option_one =", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotEqualTo(String value) {
            addCriterion("option_one <>", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneGreaterThan(String value) {
            addCriterion("option_one >", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneGreaterThanOrEqualTo(String value) {
            addCriterion("option_one >=", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLessThan(String value) {
            addCriterion("option_one <", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLessThanOrEqualTo(String value) {
            addCriterion("option_one <=", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneLike(String value) {
            addCriterion("option_one like", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotLike(String value) {
            addCriterion("option_one not like", value, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneIn(List<String> values) {
            addCriterion("option_one in", values, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotIn(List<String> values) {
            addCriterion("option_one not in", values, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneBetween(String value1, String value2) {
            addCriterion("option_one between", value1, value2, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionOneNotBetween(String value1, String value2) {
            addCriterion("option_one not between", value1, value2, "optionOne");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIsNull() {
            addCriterion("option_two is null");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIsNotNull() {
            addCriterion("option_two is not null");
            return (Criteria) this;
        }

        public Criteria andOptionTwoEqualTo(String value) {
            addCriterion("option_two =", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotEqualTo(String value) {
            addCriterion("option_two <>", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoGreaterThan(String value) {
            addCriterion("option_two >", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoGreaterThanOrEqualTo(String value) {
            addCriterion("option_two >=", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLessThan(String value) {
            addCriterion("option_two <", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLessThanOrEqualTo(String value) {
            addCriterion("option_two <=", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoLike(String value) {
            addCriterion("option_two like", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotLike(String value) {
            addCriterion("option_two not like", value, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoIn(List<String> values) {
            addCriterion("option_two in", values, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotIn(List<String> values) {
            addCriterion("option_two not in", values, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoBetween(String value1, String value2) {
            addCriterion("option_two between", value1, value2, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionTwoNotBetween(String value1, String value2) {
            addCriterion("option_two not between", value1, value2, "optionTwo");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIsNull() {
            addCriterion("option_three is null");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIsNotNull() {
            addCriterion("option_three is not null");
            return (Criteria) this;
        }

        public Criteria andOptionThreeEqualTo(String value) {
            addCriterion("option_three =", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotEqualTo(String value) {
            addCriterion("option_three <>", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeGreaterThan(String value) {
            addCriterion("option_three >", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeGreaterThanOrEqualTo(String value) {
            addCriterion("option_three >=", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLessThan(String value) {
            addCriterion("option_three <", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLessThanOrEqualTo(String value) {
            addCriterion("option_three <=", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeLike(String value) {
            addCriterion("option_three like", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotLike(String value) {
            addCriterion("option_three not like", value, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeIn(List<String> values) {
            addCriterion("option_three in", values, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotIn(List<String> values) {
            addCriterion("option_three not in", values, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeBetween(String value1, String value2) {
            addCriterion("option_three between", value1, value2, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionThreeNotBetween(String value1, String value2) {
            addCriterion("option_three not between", value1, value2, "optionThree");
            return (Criteria) this;
        }

        public Criteria andOptionFourIsNull() {
            addCriterion("option_four is null");
            return (Criteria) this;
        }

        public Criteria andOptionFourIsNotNull() {
            addCriterion("option_four is not null");
            return (Criteria) this;
        }

        public Criteria andOptionFourEqualTo(String value) {
            addCriterion("option_four =", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotEqualTo(String value) {
            addCriterion("option_four <>", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourGreaterThan(String value) {
            addCriterion("option_four >", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourGreaterThanOrEqualTo(String value) {
            addCriterion("option_four >=", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLessThan(String value) {
            addCriterion("option_four <", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLessThanOrEqualTo(String value) {
            addCriterion("option_four <=", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourLike(String value) {
            addCriterion("option_four like", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotLike(String value) {
            addCriterion("option_four not like", value, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourIn(List<String> values) {
            addCriterion("option_four in", values, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotIn(List<String> values) {
            addCriterion("option_four not in", values, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourBetween(String value1, String value2) {
            addCriterion("option_four between", value1, value2, "optionFour");
            return (Criteria) this;
        }

        public Criteria andOptionFourNotBetween(String value1, String value2) {
            addCriterion("option_four not between", value1, value2, "optionFour");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
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