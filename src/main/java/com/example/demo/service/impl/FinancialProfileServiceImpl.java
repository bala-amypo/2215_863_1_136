@Service
public class FinancialProfileServiceImpl implements FinancialProfileService {

    private final FinancialProfileRepository repo;

    public FinancialProfileServiceImpl(FinancialProfileRepository repo) {
        this.repo = repo;
    }

    public FinancialProfile createOrUpdateProfile(FinancialProfile profile) {
        if (repo.findByUserId(profile.getUser().getId()).isPresent()) {
            throw new BadRequestException("Financial profile already exists");
        }
        return repo.save(profile);
    }

    public FinancialProfile getProfileByUserId(Long userId) {
        return repo.findByUserId(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
