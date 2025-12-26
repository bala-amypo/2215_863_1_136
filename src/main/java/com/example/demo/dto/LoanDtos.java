package com.example.demo.dto;

public class LoanDtos {

    // DTO for loan submission
    public static class LoanRequestDto {
        private Double requestedAmount;
        private Integer tenureMonths;

        public LoanRequestDto() {
        }

        public Double getRequestedAmount() {
            return requestedAmount;
        }

        public void setRequestedAmount(Double requestedAmount) {
            this.requestedAmount = requestedAmount;
        }

        public Integer getTenureMonths() {
            return tenureMonths;
        }

        public void setTenureMonths(Integer tenureMonths) {
            this.tenureMonths = tenureMonths;
        }
    }

    // DTO for eligibility response
    public static class EligibilityResponseDto {
        private Boolean eligible;
        private Double maxEligibleAmount;
        private Double estimatedEmi;
        private String riskLevel;

        public Boolean getEligible() {
            return eligible;
        }

        public void setEligible(Boolean eligible) {
            this.eligible = eligible;
        }

        public Double getMaxEligibleAmount() {
            return maxEligibleAmount;
        }

        public void setMaxEligibleAmount(Double maxEligibleAmount) {
            this.maxEligibleAmount = maxEligibleAmount;
        }

        public Double getEstimatedEmi() {
            return estimatedEmi;
        }

        public void setEstimatedEmi(Double estimatedEmi) {
            this.estimatedEmi = estimatedEmi;
        }

        public String getRiskLevel() {
            return riskLevel;
        }

        public void setRiskLevel(String riskLevel) {
            this.riskLevel = riskLevel;
        }
    }
}