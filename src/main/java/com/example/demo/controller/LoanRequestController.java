@RestController
@RequestMapping("/api/loan-requests")
public class LoanRequestController {

    private final LoanRequestService loanRequestService;
    private final UserRepository userRepository;

    public LoanRequestController(LoanRequestService loanRequestService,
                                 UserRepository userRepository) {
        this.loanRequestService = loanRequestService;
        this.userRepository = userRepository;
    }

    @PostMapping
    public LoanRequest submitRequest(@RequestBody LoanRequest loanRequest) {

        if (loanRequest.getUser() == null || loanRequest.getUser().getId() == null) {
            throw new BadRequestException("User ID is required");
        }

        User user = userRepository
                .findById(loanRequest.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (loanRequest.getRequestedAmount() == null || loanRequest.getRequestedAmount() <= 0) {
            throw new BadRequestException("Requested amount must be greater than 0");
        }

        loanRequest.setUser(user);

        return loanRequestService.submitRequest(loanRequest);
    }

    @GetMapping
    public List<LoanRequest> getAllRequests() {
        return loanRequestService.getAllRequests();
    }

    @GetMapping("/user/{userId}")
    public List<LoanRequest> getRequestsByUser(@PathVariable Long userId) {

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return loanRequestService.getRequestsByUser(user);
    }

    @GetMapping("/{id}")
    public LoanRequest getRequestById(@PathVariable Long id) {

        if (id <= 0) {
            throw new BadRequestException("Invalid loan request ID");
        }

        return loanRequestService.getRequestById(id);
    }
}
