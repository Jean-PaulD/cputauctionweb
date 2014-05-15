/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.cputauctionnew.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jean-Paul
 */
@Entity
public class ItemCondition {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String condition;
    
    private ItemCondition(Builder builder) {
        name = builder.name;
    }

    public String getCondition() {
        return condition;
    }

    public static class Builder {

        private String id;
        private String name;
 public Builder(){};
        public Builder(String name) {
            this.name = name;
        }

        public ItemCondition.Builder id(String value) {
            id = value;
            return this;
        }

        public ItemCondition build() {
            return new ItemCondition(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ItemCondition itemCondition = (ItemCondition) o;

        if (!id.equals(itemCondition.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
}
