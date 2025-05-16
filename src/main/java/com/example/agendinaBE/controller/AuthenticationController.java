package com.example.agendinaBE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agendinaBE.dto.LoginRequestDTO;
import com.example.agendinaBE.dto.LoginResponseDTO;
import com.example.agendinaBE.util.JwtUtil;
import org.springframework.security.core.GrantedAuthority;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil; // Aggiungi l'utility JWT per generare il token

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            // Autenticazione dell'utente
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );

            // Imposta il contesto di sicurezza
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Ottieni il ruolo dell'utente
            String ruolo = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .findFirst()
                    .orElse("ROLE_USER"); // Default role se non trovato

            // Genera il token JWT
            String jwt = jwtUtil.generateToken(authentication);

            // Crea la risposta con il JWT e il ruolo
            LoginResponseDTO response = new LoginResponseDTO(jwt, loginRequest.getUsername(), ruolo);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali non valide");
        }
    }
}
