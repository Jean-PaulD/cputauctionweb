/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.domain.Item;
import com.mycompany.cputauctionnew.repository.ItemRepository;
import org.springframework.context.ApplicationContext;
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
public class ItemRepositoryTest {
    
    public ItemRepositoryTest() {
    }

    public static ApplicationContext ctx;
    private Long id;

    private ItemRepository repo;

    @Test
    public void addItem(){
        repo = ctx.getBean(ItemRepository.class);
        Item b = new Item.Builder(901)
                .itemName("itemName")
                .itemDescription("itemDescription")
                .price(300)
                .itemType("itemType")
                .build();
        repo.save(b);
        id = b.getId();
        Assert.assertNotNull(b);

    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
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
