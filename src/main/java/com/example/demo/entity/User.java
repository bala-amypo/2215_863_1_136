@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id @GeneratedValue
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String role = "CUSTOMER";
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    // getters & setters
}
