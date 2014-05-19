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
    private Long id;
    private String name;
    private String condition;

    private ItemCondition() {
    }

    private ItemCondition(Builder builder) {
        id = builder.id;
        name = builder.name;
        condition = builder.condition;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return id;
    }

    public String getCondition() {
        return condition;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String condition;

        public Builder ItemCondition(ItemCondition itemCondition) {
            id = itemCondition.getID();
            name = itemCondition.getCondition();
            condition = itemCondition.getCondition();
            return this;
        }

        public Builder() {
        }

        public Builder condition(String value) {
            condition = value;
            return this;
        }

        public Builder(String name1) {
            name = name1;
        }

        public Builder id(Long value) {
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
