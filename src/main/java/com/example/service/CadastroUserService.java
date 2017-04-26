package com.example.service;

import com.example.core.entity.Usuario;
import com.example.core.repository.CadastroUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author furlan
 */
@Service
public class CadastroUserService {

    @Autowired
    private CadastroUserRepository cadastroBean;

    public Usuario saveRegisterInputUser(Usuario usuario) {
        return cadastroBean.save(usuario);
    }
}
