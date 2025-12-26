package com.example.demo.dto;

import java.math.BigDecimal;

public class LoanDtos {

    public static class LoanRequestDto {
        private Long userId;
        private BigDecimal requestedAmount;
        private Integer tenureMonths;
        private String purpose;

        public LoanRequestDto() {}

        public LoanRequestDto(Long userId, BigDecimal requestedAmount, Integer tenureMonths, String purpose) {
            this.userId = userId;
            this.requestedAmount = requestedAmount;
            this.tenureMonths = tenureMonths;
            this.purpose = purpose;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public BigDecimal getRequestedAmount() {
            return requestedAmount;
        }

        public void setRequestedAmount(BigDecimal requestedAmount) {
            this.requestedAmount = requestedAmount;
        }

        public Integer getTenureMonths() {
            return tenureMonths;
        }

        public void setTenureMonths(Integer tenureMonths) {
            this.tenureMonths = tenureMonths;
        }

        public String getPurpose() {
            return purpose;
        }

        public void setPurpose(String purpose) {
            this.purpose = purpose;
        }
    }

    public static class FinancialProfileDto {
        private Long userId;
        private BigDecimal monthlyIncome;
        private BigDecimal monthlyExpenses;
        private BigDecimal existingLoanEmi;
        private Integer creditScore;
        private BigDecimal savingsBalance;

        public FinancialProfileDto() {}

        public FinancialProfileDto(Long userId, BigDecimal monthlyIncome, BigDecimal monthlyExpenses, 
                                 BigDecimal existingLoanEmi, Integer creditScore, BigDecimal savingsBalance) {
            this.userId = userId;
            this.monthlyIncome = monthlyIncome;
            this.monthlyExpenses = monthlyExpenses;
            this.existingLoanEmi = existingLoanEmi;
            this.creditScore = creditScore;
            this.savingsBalance = savingsBalance;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public BigDecimal getMonthlyIncome() {
            return monthlyIncome;
        }

        public void setMonthlyIncome(BigDecimal monthlyIncome) {
            this.monthlyIncome = monthlyIncome;
        }

        public BigDecimal getMonthlyExpenses() {
            return monthlyExpenses;
        }

        public void setMonthlyExpenses(BigDecimal monthlyExpenses) {
            this.monthlyExpenses = monthlyExpenses;
        }

        public BigDecimal getExistingLoanEmi() {
            return existingLoanEmi;
        }

        public void setExistingLoanEmi(BigDecimal existingLoanEmi) {
            this.existingLoanEmi = existingLoanEmi;
        }

        public Integer getCreditScore() {
            return creditScore;
        }

        public void setCreditScore(Integer creditScore) {
            this.creditScore = creditScore;
        }

        public BigDecimal getSavingsBalance() {
            return savingsBalance;
        }

        public void setSavingsBalance(BigDecimal savingsBalance) {
            this.savingsBalance = savingsBalance;
        }
    }
}