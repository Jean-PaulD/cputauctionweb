/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services;

import com.mycompany.cputauctionnew.domain.Bid;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface MaxBidService {

    public List<Bid> getMaxBid();
    public List<Bid> findAll();
    public Bid find(Long id);
    public Bid persist(Bid entity);
    public Bid merge(Bid entity);
    public void remove(Bid entity);
    
}
