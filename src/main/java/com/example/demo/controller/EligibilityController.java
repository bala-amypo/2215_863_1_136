@RestController
@RequestMapping("/api/eligibility")
public class EligibilityController {

    @PostMapping("/evaluate/{loanRequestId}")
    public String evaluate(@PathVariable Long loanRequestId) {

        if (loanRequestId <= 0) {
            throw new BadRequestException("Invalid loanRequestId");
        }

        return "Evaluate loan " + loanRequestId;
    }

    @GetMapping("/result/{loanRequestId}")
    public String getResult(@PathVariable Long loanRequestId) {

        if (loanRequestId <= 0) {
            throw new BadRequestException("Invalid loanRequestId");
        }

        return "Get result for loan " + loanRequestId;
    }
}
