package com.example.core.repository;

import com.example.core.entity.Usuario;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno
 */
@Repository
public interface CadastroUserRepository extends CrudRepository<Usuario, Serializable> {

    
}
