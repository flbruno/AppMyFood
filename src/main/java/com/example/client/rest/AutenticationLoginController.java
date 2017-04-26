package com.example.client.rest;

import com.example.core.entity.Usuario;
import com.example.security.SecurityAutentication;
import com.example.service.AutenticationLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author furlan
 */
@RestController
@RequestMapping("/autenticacao")
public class AutenticationLoginController {

    @Autowired
    private AutenticationLoginService autenticationService;
    @Autowired
    private SecurityAutentication security;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Usuario> authentication(@RequestBody(required = true) Usuario usuario) {

        final Usuario userRegister = autenticationService.getLoadingAutentication(usuario.getEmailUser());

        //validar se existe usuario cadastrado
        if (userRegister != null) {
            final String passwordLoginUser = security.generateHash(usuario.getSenhaUser());

            if (!(usuario.getEmailUser()).equalsIgnoreCase(userRegister.getEmailUser())
                    || !(userRegister.getSenhaUser()).equalsIgnoreCase(passwordLoginUser)) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity(userRegister, HttpStatus.OK);
    }
}
