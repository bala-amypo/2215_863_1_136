@Service
public class LoanRequestServiceImpl implements LoanRequestService {

    private final LoanRequestRepository repo;

    public LoanRequestServiceImpl(LoanRequestRepository repo) {
        this.repo = repo;
    }

    public LoanRequest submitLoanRequest(LoanRequest request) {
        if (request.getRequestedAmount() <= 0) {
            throw new BadRequestException("Requested amount");
        }
        return repo.save(request);
    }

    public List<LoanRequest> getRequestsByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    public LoanRequest getRequestById(Long id) {
        return repo.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    public List<LoanRequest> getAllRequests() {
        return repo.findAll();
    }
}
