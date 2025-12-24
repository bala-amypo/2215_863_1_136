public interface EligibilityResultRepository extends JpaRepository<EligibilityResult, Long> {
    Optional<EligibilityResult> findByLoanRequestId(Long loanRequestId);
}
