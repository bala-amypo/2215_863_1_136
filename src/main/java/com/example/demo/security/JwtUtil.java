@Component
public class JwtUtil {

    private String secret = "mySecretKey12345mySecretKey12345";
    private long validityMs = 60 * 60 * 1000;

    // ✅ REQUIRED
    public JwtUtil() {}

    // ✅ REQUIRED
    public JwtUtil(String secret, int validityMs) {
        this.secret = secret;
        this.validityMs = validityMs;
    }

    public String generateToken(String subject) {
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String generateToken(
            Map<String, Object> claims,
            String subject,
            Object ignored,
            String ignored2) {

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + validityMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public Claims getAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T extractClaim(String token, Function<Claims, T> resolver) {
        return resolver.apply(getAllClaims(token));
    }
}
