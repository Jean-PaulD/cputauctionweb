/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services;

import com.mycompany.cputauctionnew.domain.CurrentBid;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface  CheckCurrentBidService {
    
    public List<CurrentBid> getCurrentBid();
    public List<CurrentBid> finAll();
    public CurrentBid find(Long id);
    public CurrentBid persist(CurrentBid entity);
    public CurrentBid merge(CurrentBid entity);
    public void remove(CurrentBid entity);
}
