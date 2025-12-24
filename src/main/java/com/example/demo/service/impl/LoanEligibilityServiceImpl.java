@Service
public class LoanEligibilityServiceImpl implements LoanEligibilityService {

    private final LoanRequestRepository loanRepo;
    private final FinancialProfileRepository profileRepo;
    private final EligibilityResultRepository resultRepo;
    private final RiskAssessmentLogRepository riskRepo;

    public LoanEligibilityServiceImpl(
        LoanRequestRepository loanRepo,
        FinancialProfileRepository profileRepo,
        EligibilityResultRepository resultRepo,
        RiskAssessmentLogRepository riskRepo) {
        this.loanRepo = loanRepo;
        this.profileRepo = profileRepo;
        this.resultRepo = resultRepo;
        this.riskRepo = riskRepo;
    }

    public EligibilityResult evaluateEligibility(Long loanRequestId) {
        LoanRequest req = loanRepo.findById(loanRequestId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        FinancialProfile profile = profileRepo.findByUserId(req.getUser().getId())
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        double dti = (profile.getMonthlyExpenses() + profile.getExistingLoanEmi()) / profile.getMonthlyIncome();
        String risk = dti > 0.5 ? "HIGH" : "LOW";

        EligibilityResult result = new EligibilityResult();
        result.setLoanRequest(req);
        result.setIsEligible(dti < 0.6 && profile.getCreditScore() >= 600);
        result.setRiskLevel(risk);
        result.setMaxEligibleAmount(profile.getMonthlyIncome() * 10);

        resultRepo.save(result);

        riskRepo.save(new RiskAssessmentLog(req.getId(), dti, "CHECKED"));
        return result;
    }
}
