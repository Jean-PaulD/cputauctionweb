/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.CPUTAuction.repository;

import static com.mycompany.CPUTAuction.repository.LogsRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Logs;
import com.mycompany.cputauctionnew.domain.Logs;
import com.mycompany.cputauctionnew.repository.LogsRepository;
import com.mycompany.cputauctionnew.repository.LogsRepository;
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
public class LogsRepositoryTest {
    public static ApplicationContext ctx;
    private Long id;

    private LogsRepository repo;

    
    public LogsRepositoryTest() {
    }

    @Test
    public void createLogs() {

        repo = ctx.getBean(LogsRepository.class);
        Logs u = new Logs.Builder("14:00")
                .build();
        repo.save(u);
        id = u.getID(); 
        Assert.assertNotNull(u);

    }

    @Test(dependsOnMethods = "createLogs")
    public void readLogs() {
        repo = ctx.getBean(LogsRepository.class);
        Logs b = repo.findOne(id);
        Assert.assertEquals(b.getTmpLog(), "14:00");

    }

    @Test(dependsOnMethods = "readLogs")
    private void updateLogs() {
        repo = ctx.getBean(LogsRepository.class);
        Logs b = repo.findOne(id);
        Logs updatedLogs = new Logs.Builder("15:00")
                .build();

        repo.save(updatedLogs);

        Logs newLogs = repo.findOne(id);
        Assert.assertEquals(newLogs.getTmpLog(), "15:00");

    }

    @Test(dependsOnMethods = "updateLogs")
    private void deleteLogs() {
        repo = ctx.getBean(LogsRepository.class);
        Logs b = repo.findOne(id);
        repo.delete(b);

        Logs deletedLogs = repo.findOne(id);

        Assert.assertNull(deletedLogs);

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
