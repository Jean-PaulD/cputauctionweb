/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.services.Impl;

import com.mycompany.cputauctionnew.services.GetSellerService;
import com.mycompany.cputauctionnew.domain.Seller;
import com.mycompany.cputauctionnew.repository.SellerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetSellerServiceImpl implements GetSellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public List<Seller> getSeller(String abc) {

        List<Seller> sellers = new ArrayList<>();
        List<Seller> allSellers = sellerRepository.findAll();

        for(Seller seller: allSellers){
            if(seller.getUsername().equals(abc)){
                sellers.add(seller);
            }
        }
        
        return sellers;
    }

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

}
