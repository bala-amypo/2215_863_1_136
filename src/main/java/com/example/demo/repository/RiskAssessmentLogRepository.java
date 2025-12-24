public interface RiskAssessmentLogRepository extends JpaRepository<RiskAssessmentLog, Long> {
    List<RiskAssessmentLog> findByLoanRequestId(Long requestId);
}
