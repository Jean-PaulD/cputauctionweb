/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Persistence;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class Bid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // private int age;
    private double amount;
    @Column(unique = true)
    private Long Bid_id;
   // private String email;

    //private long itemID;
    //@Embedded
    //private Contact contact;
    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "bid_id")
    //List<Account> account;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_CPUTAuctionNew_war_1.0-SNAPSHOTPU");

    @OneToMany
    @JoinColumn(name = "bid_id")
    private List<BidsWon> bidsWon;
    @OneToMany
    @JoinColumn(name = "bid_id")
    private List<CancelBid> cancelBid;
    @OneToMany
    @JoinColumn(name = "bid_id")
    private List<CurrentBid> currentBid;
    @OneToMany
    @JoinColumn(name = "bid_id")
    private List<Item> item;

    private Bid(Builder builder) {

        id = builder.id;
        bidsWon = builder.bidsWon;
        cancelBid = builder.cancelBid;
        currentBid = builder.currentBid;
        amount = builder.amount;
        Bid_id = builder.Bid_id;
    }

    public Bid() {

    }

    public double getAmount() {
        return amount;
    }

    public long getBidID() {
        return Bid_id;
    }

    public Long getId() {

        return id;
    }

    public static class Builder {

        private long id;
        private long Bid_id;
        private double amount;
        private List<BidsWon> bidsWon;
        private List<CancelBid> cancelBid;
        private List<CurrentBid> currentBid;
        private List<Item> item;

        public Builder(long i) {
            amount = i;
        }

        public Builder amount(double amt) {
            amount = amt;
            return this;
        }

        private Builder bidsWon(List<BidsWon> value) {
            bidsWon = value;
            return this;
        }

        private Builder cancelBid(List<CancelBid> value) {
            cancelBid = value;
            return this;
        }

        private Builder currentBid(List<CurrentBid> value) {
            currentBid = value;
            return this;
        }

        private Builder item(List<Item> value) {
            item = value;
            return this;
        }

        public Bid build() {
            return new Bid(this);
        }

        public Builder b(Bid b) {

            return this;
        }

        public Builder id(Long value) {
            id = value;
            return this;
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
        if (!(object instanceof Bid)) {
            return false;
        }
        Bid other = (Bid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cputauctionnew.domain.Bid[ id=" + id + " ]";
    }

    public void persist(Object object) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
