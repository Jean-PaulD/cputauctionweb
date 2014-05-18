/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.cputauctionnew.services.BidsAmountService;
import static com.mycompany.CPUTAuction.repository.BidRepositoryTest.ctx;
import static com.mycompany.CPUTAuction.repository.LogsRepositoryTest.ctx;
import com.mycompany.cputauctionnew.app.config.ConnectionConfig;
import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
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
public class MakeBidServiceTest {

    public static ApplicationContext ctx;
    private Long id;

    private BidRepository bidRepository;
    private BidsAmountService bidsAmountService;
    
    @Test
    public MakeBidServiceTest() {

        bidRepository = ctx.getBean(BidRepository.class);
        bidsAmountService = ctx.getBean(BidsAmountService.class);

        Bid b1 = new Bid.Builder(123)
                .amount(400)
                .build();

        Bid b2 = new Bid.Builder(123)
                .amount(300)
                .build();

        Bid b3 = new Bid.Builder(123)
                .amount(130)
                .build();

        bidRepository.save(b1);
        bidRepository.save(b2);
        bidRepository.save(b3);
        
        List<Bid> bids = bidsAmountService.getBidAbove(200);
        Assert.assertEquals(bids.size(), 3);
        
    }

    @Test
    public void getBidAmountTest() {

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

     @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
       bidRepository = ctx.getBean(BidRepository.class);
       bidRepository.deleteAll();
    }
}
