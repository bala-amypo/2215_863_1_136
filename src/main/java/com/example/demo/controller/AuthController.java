@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        if (request.getUsername() == null || request.getUsername().isEmpty()) {
            throw new BadRequestException("Username is required");
        }

        return "User registered: " + request.getUsername();
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        if (request.getUsername() == null || request.getPassword() == null) {
            throw new BadRequestException("Username and password are required");
        }

        return "User logged in: " + request.getUsername();
    }
}
