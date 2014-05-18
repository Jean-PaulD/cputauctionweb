/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Users;
import com.mycompany.cputauctionnew.repository.UsersRepository;
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
public class UsersRepositoryTest {
    
    public static ApplicationContext ctx;
    private Long id;

    private UsersRepository repo;

    
    public UsersRepositoryTest() {
    }

    @Test
    public void createUsers() {

        repo = ctx.getBean(UsersRepository.class);
        Users u = new Users.Builder("admin")
                .logs(null)
                .build();
        repo.save(u);
        id = u.getID(); 
        Assert.assertNotNull(u);

    }

    @Test(dependsOnMethods = "createUsers")
    public void readUsers() {
        repo = ctx.getBean(UsersRepository.class);
        Users b = repo.findOne(id);
        Assert.assertEquals(b.accountType(), "admin");

    }

    @Test(dependsOnMethods = "readUsers")
    private void updateUsers() {
        repo = ctx.getBean(UsersRepository.class);
        Users b = repo.findOne(id);
        Users updatedUsers = new Users.Builder("normal")
                .logs(null)
                .build();

        repo.save(updatedUsers);

        Users newUsers = repo.findOne(id);
        Assert.assertEquals(newUsers.accountType(), "normal");

    }

    @Test(dependsOnMethods = "updateUsers")
    private void deleteUsers() {
        repo = ctx.getBean(UsersRepository.class);
        Users b = repo.findOne(id);
        repo.delete(b);

        Users deletedUsers = repo.findOne(id);

        Assert.assertNull(deletedUsers);

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
