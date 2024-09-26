package com.seubone.sistemavendas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seubone.sistemavendas.dto.AuthenticationDTO;
import com.seubone.sistemavendas.dto.LoginResponseDTO;
import com.seubone.sistemavendas.dto.RegisterDTO;
import com.seubone.sistemavendas.model.User;
import com.seubone.sistemavendas.repository.UserRepository;
import com.seubone.sistemavendas.security.TokenService;

import jakarta.validation.Valid;

@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());
        System.out.println("User: " + ((User)auth.getPrincipal()).getUsername());
        return ResponseEntity.ok(new LoginResponseDTO(token, ((User)auth.getPrincipal()).getUsername()));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDTO data){
        if (this.repository.findByLogin(data.login()) != null){
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User usuario = new User(data.login(), encryptedPassword, data.role());

        this.repository.save(usuario);

        return ResponseEntity.ok().build();
    }

}
