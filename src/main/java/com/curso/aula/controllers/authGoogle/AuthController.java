package com.curso.aula.controllers.authGoogle;

import com.curso.aula.entities.User;
import com.curso.aula.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/login")
    public String showLoginPage(Model model) {
        logger.info("Processing login request for email:");
        return "login";
    }


    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("email") String email,
                               @RequestParam("password") String password,
                               RedirectAttributes redirectAttributes) {
        logger.info("Processing login request for email: {}", email);
        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            logger.info("Invalid email or password");
            redirectAttributes.addFlashAttribute("errorMessage", "Credenciais inválidas");
            return "redirect:/login";
        }

        redirectAttributes.addFlashAttribute("successMessage", "Login bem-sucedido!");
        return "redirect:/home";
    }
}

