public interface FinancialProfileRepository extends JpaRepository<FinancialProfile, Long> {
    Optional<FinancialProfile> findByUserId(Long userId);
}
