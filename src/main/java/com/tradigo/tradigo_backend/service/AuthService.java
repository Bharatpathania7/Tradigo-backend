package com.tradigo.tradigo_backend.service;

import com.tradigo.tradigo_backend.config.JwtUtil;
import com.tradigo.tradigo_backend.dto.LoginRequest;
import com.tradigo.tradigo_backend.model.User;
import com.tradigo.tradigo_backend.repository.UserRepository;
import com.tradigo.tradigo_backend.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = User.builder()
                .role(request.getRole().toUpperCase())
                .name(request.getName())
                .phone(request.getPhone())
                .businessName(request.getBusinessName())
                .location(request.getLocation())
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .createdAt(System.currentTimeMillis())
                .build();

                userRepository.save(user);

        return "User registered successfully";
    }

    public Object login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return new java.util.HashMap<>() {{
            put("token", token);
            put("user", user);
        }};
    }

}
