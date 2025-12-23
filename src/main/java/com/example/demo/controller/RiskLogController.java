@RestController
@RequestMapping("/api/risk-logs")
public class RiskLogController {

    @GetMapping("/{loanRequestId}")
    public String getLogs(@PathVariable Long loanRequestId) {

        if (loanRequestId <= 0) {
            throw new BadRequestException("Invalid loanRequestId");
        }

        return "Get risk logs for loan " + loanRequestId;
    }
}
