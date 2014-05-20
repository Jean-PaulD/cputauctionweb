/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.repository;

import static com.mycompany.CPUTAuction.repository.AccountRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Item;
import com.mycompany.cputauctionnew.repository.ItemRepository;
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
public class ItemRepositoryTest {

    public ItemRepositoryTest() {
    }

    public static ApplicationContext ctx;
    private Long id;

    private ItemRepository repo;

    @Test
    public void addItem() {
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

    @Test(dependsOnMethods = "addItem")
    public void readBid() {
        repo = ctx.getBean(ItemRepository.class);
        Item b = repo.findOne(id);
        Assert.assertEquals(b.getItemDescription(), "itemDescription");
    }

    @Test(dependsOnMethods = "readBid")
    private void updateBid() {
        repo = ctx.getBean(ItemRepository.class);
        Item b = repo.findOne(id);
        Item updatedBid = new Item.Builder(901)
                .item(b)
                .itemName("itemName")
                .itemDescription("itemDescription")
                .price(201)
                .itemType("itemType")
                .build();

        repo.save(updatedBid);

        Item newBid = repo.findOne(id);
        Assert.assertEquals(newBid.getPrice(), 201.0);//201.0

    }

    @Test(dependsOnMethods = "updateBid")
    private void deleteBid() {
        repo = ctx.getBean(ItemRepository.class);
        Item b = repo.findOne(id);
        repo.delete(b);

        Item deletedBid = repo.findOne(id);

        Assert.assertNull(deletedBid);
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
