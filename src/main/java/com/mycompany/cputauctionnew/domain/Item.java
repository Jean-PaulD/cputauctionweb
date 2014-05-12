/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
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
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private int itemID;
    private String itemName;
    private String itemDescription;
    private String itemType;
    private double price;
    //@Embedded
    //private Contact contact;
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "bid_id")
    //List<Account> account;
    /*@OneToMany
    @JoinColumn(name = "Item_id")
    private List<Electronics> electronics;
    @OneToMany
    @JoinColumn(name = "Item_id")
    private List<Books> books;
    @OneToMany
    @JoinColumn(name = "Item_id")
    private List<ItemCondition> itemCondition;
*/
    
    private Item(Builder aThis) {
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
        Item other = (Item) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.Item[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public static class Builder {

        private long id;
        private int itemID;
        private String itemName;
        private String itemDescription;
        private double price;
        private String itemType;
        
        public Builder(int i) {
            id = i;
        }
        
        public Builder id (long i){
          id = i;
          return this;
        }
        public Builder itemName(String itemName1) {
            itemName = itemName1;
            return this;
        }

        public Builder itemDescription(String itemDescription1) {
            itemDescription = itemDescription1;
            return this;
        }

        public Builder price(double i) {
            price = i;
            return this;
        }

        public Builder itemType(String itemType1) {
            itemType = itemType1; 
            return this;
        }

        public Item build() {
            return new Item(this);
        }

    }

}