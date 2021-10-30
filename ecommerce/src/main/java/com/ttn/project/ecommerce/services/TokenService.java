package com.ttn.project.ecommerce.services;

import com.ttn.project.ecommerce.entities.Customer;
import com.ttn.project.ecommerce.entities.Token;
import com.ttn.project.ecommerce.entities.User;
import com.ttn.project.ecommerce.repos.TokenRepository;
import com.ttn.project.ecommerce.repos.UserRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.keygen.BytesKeyGenerator;
import org.springframework.security.crypto.keygen.KeyGenerators;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDateTime;

@Service
public class TokenService {
    private static final BytesKeyGenerator DEFAULT_TOKEN_GENERATOR = KeyGenerators.secureRandom(15);
    private static final Charset US_ASCII = Charset.forName("US-ASCII");


    @Autowired
    TokenRepository tokenRepo;
    @Autowired
    UserRepository userRepo;

//    public Token createToken(String email){
//        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII); // this is a sample, you can adapt as per your security need
//        User u=userRepo.findByEmail(email);
//        Token token = new Token(u);
//        token.setToken(tokenValue);
//        token.setExpireAt(LocalDateTime.now().plusSeconds(999999999));
//    //    User u=userRepo.findByEmail(email);
//    //    token.setUser(u);
//        token.setEmail(email);
//        tokenRepo.save(token);
//        return token;
//
//    }

    public Token createToken(User user){
        String tokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII); // this is a sample, you can adapt as per your security need
        Token token = new Token(user);
        token.setToken(tokenValue);
        System.out.println("token value " + tokenValue);
        token.setExpireAt(LocalDateTime.now().plusSeconds(999999999));
    //    token.setExpireAt(LocalDateTime.now().plusSeconds(1l));
        token.setEmail(user.getEmail());
        tokenRepo.save(token);
        return token;
    }


    public Token generateNewToken(Token token){
        String newTokenValue = new String(Base64.encodeBase64URLSafe(DEFAULT_TOKEN_GENERATOR.generateKey()), US_ASCII); // this is a sample, you can adapt as per your security need
        Token newToken = new Token(token.getUser());
        newToken.setToken(newTokenValue);
        System.out.println("newToken value " + newTokenValue);
        newToken.setExpireAt(LocalDateTime.now().plusSeconds(999999999));
        newToken.setEmail(token.getUser().getEmail());
        tokenRepo.save(newToken);

//        token.setExpireAt(LocalDateTime.now().plusSeconds(999999999));
//        token.setToken(newTokenValue);
//        tokenRepo.save(token);
        return newToken;
    }




}
