@Entity
public class RiskAssessmentLog {
    @Id @GeneratedValue
    private Long id;

    private Long loanRequestId;
    private Double dtiRatio;
    private String creditCheckStatus;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());
}
