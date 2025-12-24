@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    private final FinancialProfileService service;

    public FinancialProfileController(FinancialProfileService service) {
        this.service = service;
    }

    @PostMapping
    public FinancialProfile save(@RequestBody FinancialProfile profile) {
        return service.createOrUpdateProfile(profile);
    }

    @GetMapping("/user/{id}")
    public FinancialProfile get(@PathVariable Long id) {
        return service.getProfileByUserId(id);
    }
}
