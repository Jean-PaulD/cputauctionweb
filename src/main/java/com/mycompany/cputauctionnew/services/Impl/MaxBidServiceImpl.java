/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.domain.Bid;
import com.mycompany.cputauctionnew.repository.BidRepository;
import com.mycompany.cputauctionnew.services.MaxBidService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaxBidServiceImpl implements MaxBidService {

    @Autowired
    private BidRepository bidRepository;

    @Override
    public List<Bid> getMaxBid() {
        List<Bid> bids = new ArrayList<>();
        List<Bid> allBids = bidRepository.findAll();

        double temp = 0;

        for (Bid bid : allBids) {
            if (bid.getAmount() > temp) {
                temp = bid.getAmount();
                bids.add(bid);
            }
        }

        return bids;
    }

    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }
}
