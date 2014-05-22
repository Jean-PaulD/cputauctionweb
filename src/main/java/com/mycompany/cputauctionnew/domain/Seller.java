/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class Seller implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    @OneToMany
    @JoinColumn(name = "Seller_id")
    private List<Bid> bid;

    private Seller() {
    }

    private Seller(Builder builder) {
        id = builder.id;
        username = builder.username;
    }

    public String getUsername() {

        return username;
    }

    public Long getID() {
        return id;
    }
    
    public Long getId() {
        return id;
    }

    public static class Builder {

        private Long id;
        private String username;
        private List<Bid> bid;

        public Builder seller(Seller s) {
            id = s.getID();
            username = s.getUsername();
            return this;
        }

        public Builder() {
        }

        public Builder(String username1) {
            username = username1;
        }
        
        public Builder username(String i){
            username = i;
            return this;}
        
        /*public List<Bid> bid_id(Long i){
         return bid;
         }*/
        public Builder id(Long value) {
            id = value;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }
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
        if (!(object instanceof Seller)) {
            return false;
        }
        Seller other = (Seller) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.Seller[ id=" + id + " ]";
    }

}
