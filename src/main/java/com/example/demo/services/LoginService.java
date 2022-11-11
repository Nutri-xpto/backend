package com.example.demo.services;

import com.example.demo.model.Nutritionist;
import com.example.demo.repositories.NutritionistRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class LoginService {

    private final static SecretKey KEY = Keys.hmacShaKeyFor("7f-j&CKk=coNzZc0y7_4obMP?#TfcYq%fcD0mDpenW2nc!lfGoZ|d?f&RNbDHUX6".getBytes(StandardCharsets.UTF_8)) ;
    // Chave para autenticação JWT -- Colocar em .env

    private final NutritionistRepository repository;

    public LoginService(NutritionistRepository repository) { this.repository = repository; }

    public String JWTToken(String email, String  password){
        Nutritionist nutri =  this.repository.findNutritionistByEmail(email) ;

        if ( nutri.getPassword().equals(password)) {
            return Jwts.builder()
                    .setSubject(nutri.getEmail())
                    .setIssuer("localhost://8080")
                    .setIssuedAt(new Date())
                    .setExpiration(
                            Date.from(LocalDateTime.now().plusMinutes(15L)
                                    .atZone(ZoneId.systemDefault())
                                    .toInstant()))
                    .signWith(KEY, SignatureAlgorithm.HS256)
                    .compact();
        }
        throw new SecurityException();
    }

}
