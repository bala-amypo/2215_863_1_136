@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository resultRepo;

    public LoanEligibilityServiceImpl(
        LoanRequestRepository loanRepo,
        FinancialProfileRepository profileRepo,
        EligibilityResultRepository resultRepo) {

        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.resultRepo = resultRepo;
    }

    public EligibilityResult evaluateEligibility(Long loanRequestId) {

        LoanRequest req = loanRepo.findById(loanRequestId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        FinancialProfile profile = profileRepo.findByUserId(req.getUser().getId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        double dti = (profile.getMonthlyExpenses() + profile.getExistingLoanEmi())
                / profile.getMonthlyIncome();

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(req);
        result.setIsEligible(dti < 0.6 && profile.getCreditScore() >= 600);
        result.setRiskLevel(dti > 0.5 ? "HIGH" : "LOW");
        result.setMaxEligibleAmount(profile.getMonthlyIncome() * 10);

        return resultRepo.save(result);
    }

    public EligibilityResult getResultByRequest(Long requestId) {
        return resultRepo.findByLoanRequestId(requestId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
