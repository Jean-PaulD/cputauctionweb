/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.CPUTAuction.services;

import static com.mycompany.CPUTAuction.repository.UsersRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Users;
import com.mycompany.cputauctionnew.repository.UsersRepository;
import com.mycompany.cputauctionnew.services.UserTypeService;
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
public class CheckUserTypeServiceTest {

    public CheckUserTypeServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    public static ApplicationContext ctx;
    private Long id;

    private UsersRepository usersRepository;
    private UserTypeService userType;

    @Test
    public void checkUserType() {
        usersRepository = ctx.getBean(UsersRepository.class);
        userType = ctx.getBean(UserTypeService.class);

        Users u1 = new Users.Builder("admin")
                .logs(null)
                .build();
        Users u2 = new Users.Builder("normal")
                .logs(null)
                .build();
        Users u3 = new Users.Builder("admin")
                .logs(null)
                .build();

        usersRepository.save(u1);
        usersRepository.save(u2);
        usersRepository.save(u3);
        List<Users> users = userType.getAdmin();
        Assert.assertEquals(users.size(), 2);
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
