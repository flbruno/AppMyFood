package com.example.service;

import com.example.core.repository.FoodRepository;
import com.example.core.entity.Food;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author bruno
 */
@Service
public class FoodService {

    @Autowired
    private FoodRepository repository;

    public List<Food> getFoodServico() {

        //return (List<Food>) repository.findAll();
        return (List<Food>) repository.findByNameOrderByNameAsc("Bruno");
    }

    public void saveFoodServico() {
        Food f = new Food();
        f.setName("Bruno");

        repository.save(f);

        Food f2 = new Food();
        f2.setName("Test");

        repository.save(f2);
    }
}
