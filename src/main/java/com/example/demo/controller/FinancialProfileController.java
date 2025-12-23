@RestController
@RequestMapping("/api/financial-profiles")
public class FinancialProfileController {

    @PostMapping
    public String createOrUpdateProfile(@RequestBody FinancialProfileRequest request) {

        if (request.getIncome() <= 0) {
            throw new BadRequestException("Income must be greater than zero");
        }

        return "Profile saved. Income: " + request.getIncome();
    }

    @GetMapping("/user/{userId}")
    public String getProfile(@PathVariable Long userId) {

        if (userId <= 0) {
            throw new BadRequestException("Invalid userId");
        }

        return "Get profile for user " + userId;
    }
}
