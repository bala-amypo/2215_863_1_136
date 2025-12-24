public interface LoanRequestRepository extends JpaRepository<LoanRequest, Long> {
    List<LoanRequest> findByUserId(Long userId);
}
