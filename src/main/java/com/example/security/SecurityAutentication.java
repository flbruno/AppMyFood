package com.example.security;

import javax.annotation.Resource;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author furlan
 */
@Service
public class SecurityAutentication {

    public String generateHash(String password) {

        MessageDigestPasswordEncoder digestPasswordEncoder = getInstanceMessageDisterPassword();
        String encodePassword = digestPasswordEncoder.encodePassword(password, null);

        return encodePassword;

    }

    private MessageDigestPasswordEncoder getInstanceMessageDisterPassword() {

        MessageDigestPasswordEncoder digestPasswordEncoder = new MessageDigestPasswordEncoder("SHA-256");

        return digestPasswordEncoder;
    }

    public boolean isPasswordValid(String password, String hashPassword) {

        MessageDigestPasswordEncoder digestPasswordEncoder = getInstanceMessageDisterPassword();

        return digestPasswordEncoder.isPasswordValid(hashPassword, password, null);
    }
}
