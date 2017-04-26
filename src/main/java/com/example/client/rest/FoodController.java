package com.example.client.rest;

import com.example.service.FoodService;
import com.example.core.entity.Food;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author furlan
 */
@RestController
@RequestMapping("/cadastro")
public class FoodController {

    @Autowired
    private FoodService service;

    @RequestMapping("/food")
    public @ResponseBody List<Food> getFood() {
        
        service.saveFoodServico();
        return service.getFoodServico();
    }
}
