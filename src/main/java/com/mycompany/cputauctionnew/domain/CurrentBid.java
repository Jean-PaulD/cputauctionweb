/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class CurrentBid implements Serializable {

    private static final long serialVersionUID = 1L;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double bidPrice;
    private String seller;

    private CurrentBid() {
    }

    private CurrentBid(Builder builder) {
        id = builder.id;
        bidPrice = builder.bidPrice;
        seller = builder.seller;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bid)) {
            return false;
        }
        CurrentBid other = (CurrentBid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.CurrentBid[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public String getSeller() {
        return seller;
    }

    public static class Builder {

        private Long id;
        private double bidPrice;
        private String seller;
        public Builder(){}
        public Builder(double i) {
            bidPrice = i;
        }
        
        public Builder bidPrice( double i){
            bidPrice = i;
            return this;
        }
        
        public Builder currentBid(CurrentBid c) {
            id = c.getId();
            bidPrice = c.getBidPrice();
            seller = c.getSeller();
            return this;
        }

        public Builder seller(String sellerName) {
            sellerName = seller;
            return this;
        }

        public CurrentBid build() {
            return new CurrentBid(this);
        }


    }

}
