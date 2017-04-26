package com.example.core.repository;

import com.example.core.entity.Food;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bruno
 */
@Repository
public interface FoodRepository extends CrudRepository<Food, Serializable>{
    
    public List<Food> findByNameOrderByNameAsc(String name);
}
