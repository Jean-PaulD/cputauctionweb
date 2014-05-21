/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.services;

import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.ItemCondition;
import com.mycompany.cputauctionnew.repository.ItemConditionRepository;
import com.mycompany.cputauctionnew.services.ItemConditionService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Jean-Paul
 */
public class CheckItemConditionServiceTest {
    
    public CheckItemConditionServiceTest() {
    }
    public static ApplicationContext ctx;
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    
    private Long id;

    private ItemConditionRepository itemConditionRepository;
    private ItemConditionService itemConditionService;
    
    @Test
    public void checkCondition(){
        itemConditionRepository = ctx.getBean(ItemConditionRepository.class);
        itemConditionService = ctx.getBean(ItemConditionService.class);

        ItemCondition i1 = new ItemCondition.Builder("Jean")
                .condition("good")
                .build();
        
        ItemCondition i2 = new ItemCondition.Builder("Jack")
                .condition("bad")
                .build();
        
        ItemCondition i3 = new ItemCondition.Builder("Jason")
                .condition("good")
                .build();
        
        itemConditionRepository.save(i1);
        itemConditionRepository.save(i2);
        itemConditionRepository.save(i3);
        
        List<ItemCondition> i = itemConditionService.getItemCondition("Good");

        Assert.assertEquals(i.size(), 2);
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       itemConditionRepository = ctx.getBean(ItemConditionRepository.class);
       itemConditionRepository.deleteAll();
    }
}
