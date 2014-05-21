/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.ItemCondition;
import com.mycompany.cputauctionnew.repository.ItemConditionRepository;
import com.mycompany.cputauctionnew.services.ItemConditionService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemConditionServiceImpl implements ItemConditionService {

    @Autowired
    private ItemConditionRepository itemConditionRepository;
    
    @Override
    public List<ItemCondition> getItemCondition(String good) {
        List<ItemCondition> conditions = new ArrayList<>();
        List<ItemCondition> allConditions = itemConditionRepository.findAll();
        
        for (ItemCondition condition : allConditions) {
            if (condition.getCondition().equals("good")) {
                conditions.add(condition);
            }
        }
        
        return conditions;
    }

    @Override
    public List<ItemCondition> findAll() {
        return itemConditionRepository.findAll();
    }

}
