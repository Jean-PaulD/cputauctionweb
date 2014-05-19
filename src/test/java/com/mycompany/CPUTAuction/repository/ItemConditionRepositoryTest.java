/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.repository.ItemConditionRepository;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.ItemCondition;
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
public class ItemConditionRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private ItemConditionRepository repo;

    public ItemConditionRepositoryTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void createItemCondition() {

        repo = ctx.getBean(ItemConditionRepository.class);
        ItemCondition u = new ItemCondition.Builder("Jean-Paul")
                .condition("bad")
                .build();
        repo.save(u);
        id = u.getID(); 
        Assert.assertNotNull(u);

    }

    @Test(dependsOnMethods = "createItemCondition")
    public void readItemCondition() {
        repo = ctx.getBean(ItemConditionRepository.class);
        ItemCondition b = repo.findOne(id);
        Assert.assertEquals(b.getCondition(), "bad");

    }

    @Test(dependsOnMethods = "readItemCondition")
    private void updateItemCondition() {
        repo = ctx.getBean(ItemConditionRepository.class);
        ItemCondition b = repo.findOne(id);
        ItemCondition updatedItemCondition = new ItemCondition.Builder("newName")
                .condition("good")
                .ItemCondition(b)
                .build();

        repo.save(updatedItemCondition);

        ItemCondition newItemCondition = repo.findOne(id);
        Assert.assertEquals(newItemCondition.getCondition(), "good");

    }

    @Test(dependsOnMethods = "updateItemCondition")
    private void deleteItemCondition() {
        repo = ctx.getBean(ItemConditionRepository.class);
        ItemCondition b = repo.findOne(id);
        repo.delete(b);

        ItemCondition deletedItemCondition = repo.findOne(id);

        Assert.assertNull(deletedItemCondition);

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
    }
}
