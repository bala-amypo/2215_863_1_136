@Entity
public class LoanRequest {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    private Double requestedAmount;
    private Integer tenureMonths;
    private String purpose;
    private String status = "PENDING";
    private Timestamp appliedAt = new Timestamp(System.currentTimeMillis());
}
