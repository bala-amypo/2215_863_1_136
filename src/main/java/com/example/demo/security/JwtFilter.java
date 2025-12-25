@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtUtil jwtUtil;

    // ✅ REQUIRED BY TESTS
    public JwtFilter() {}

    // ✅ REQUIRED BY TESTS
    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    private static final String SECRET_KEY =
            "mySecretKey12345mySecretKey12345";

    private static final SecretKey KEY =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return path.startsWith("/swagger-ui")
                || path.startsWith("/v3/api-docs")
                || path.startsWith("/auth");
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            try {
                Claims claims = Jwts.parserBuilder()
                        .setSigningKey(KEY)
                        .build()
                        .parseClaimsJws(authHeader.substring(7))
                        .getBody();

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                claims.getSubject(),
                                null,
                                Collections.emptyList()
                        );

                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);

            } catch (Exception ignored) {
                SecurityContextHolder.clearContext();
            }
        }

        filterChain.doFilter(request, response);
    }
}
