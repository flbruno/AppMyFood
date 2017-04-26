package com.example.client.rest;

import com.example.core.entity.Usuario;
import com.example.security.SecurityAutentication;
import com.example.service.CadastroUserService;
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
@RequestMapping("/autenticacao/cadastro")
public class CadastroUserController {

    @Autowired
    private CadastroUserService cadastroService;
    @Autowired
    private SecurityAutentication security;

    @RequestMapping(value = "/usuario", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {

        if (!usuario.getNameUser().trim().isEmpty() || usuario.getNameUser() != null
                || !usuario.getEmailUser().trim().isEmpty() || usuario.getEmailUser() != null
                || !usuario.getSenhaUser().trim().isEmpty() || usuario.getSenhaUser() != null
                || !usuario.getConfirmarSenha().trim().isEmpty() || usuario.getConfirmarSenha() != null) {

            usuario.setSenhaUser(security.generateHash(usuario.getSenhaUser()));

            final Usuario userSaved = cadastroService.saveRegisterInputUser(usuario);

            if (userSaved == null || userSaved.getId() == 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            return new ResponseEntity(userSaved, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
