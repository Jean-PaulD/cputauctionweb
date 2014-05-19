/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.services.BidsAmountService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BidsAmountServiceImpl implements BidsAmountService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getBidAbove(double amount) {
        List<Bid> bids = new ArrayList<>();
        List<Bid> allBids = bidRepository.findAll();

        for (Bid bid : allBids) {
            if (bid.getAmount() > amount) {
                bids.add(bid);
            }
        }
        return bids;
    }
    
    public List<Bid> findAll() {
       return bidRepository.findAll();
    }
    
}
