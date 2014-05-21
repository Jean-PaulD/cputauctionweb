/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services;

import com.mycompany.cputauctionnew.domain.ItemCondition;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface ItemConditionService {

    public List<ItemCondition> getItemCondition(String good);
    public List<ItemCondition> findAll();
    
}
