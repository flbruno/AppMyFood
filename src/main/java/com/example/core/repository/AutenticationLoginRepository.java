package com.example.core.repository;

import com.example.core.entity.Usuario;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author furlan
 */
@Repository
public interface AutenticationLoginRepository extends JpaRepository<Usuario, Serializable> {

    public Usuario findUsuarioByEmailUser(String emailUser);
}
