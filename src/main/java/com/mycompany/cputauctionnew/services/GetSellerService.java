/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.services;

import com.mycompany.cputauctionnew.domain.Seller;
import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public interface GetSellerService {

    public List<Seller> getSeller(String abc);
    public List<Seller> findAll();
    public Seller find(Long id);
    public Seller persist(Seller entity);
    public Seller merge(Seller entity);
    public void remove(Seller entity);
    
}
