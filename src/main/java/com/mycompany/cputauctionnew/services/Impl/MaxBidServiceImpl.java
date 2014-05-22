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
    
    
    @Override
    public Bid find(Long id) {
        return bidRepository.findOne(id);
    }

    @Override
    public Bid persist(Bid entity) {
        return bidRepository.save(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bid merge(Bid entity) {

        if (entity.getId() != null) {
            return bidRepository.save(entity);
        }
        return null;
    }

    @Override
    public void remove(Bid entity) {
        bidRepository.delete(entity); //To change body of generated methods, choose Tools | Templates.
    }
}
