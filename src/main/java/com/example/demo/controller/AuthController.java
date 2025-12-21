@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    UserService service;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User u = service.login(user.getEmail(), user.getPassword());
        return jwtUtil.generateToken(u.getEmail());
    }
}
