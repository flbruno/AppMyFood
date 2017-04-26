package com.example.service;

import com.example.core.entity.Usuario;
import com.example.core.repository.AutenticationLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author furlan
 */
@Service
public class AutenticationLoginService {

    @Autowired
    AutenticationLoginRepository autenticationBean;

    public Usuario getLoadingAutentication(String email) {
        return autenticationBean.findUsuarioByEmailUser(email);
    }
}
