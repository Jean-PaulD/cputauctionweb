/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

import java.util.List;

/**
 *
 * @author Jean-Paul
 */
public class Electronics {

    private String id;
    private double price;
    private String name;
    private List<Tablets> tablet;
    private List<Cellphones> cellphones;
    private List<Storage> storage;
    private List<Laptops> laptops;
    private List<Peripheral> peripheral;

    private Electronics(Builder builder) {
        id = builder.id;
        name = builder.name;
        price = builder.price;
    }

    public String getId() {
        return id;
    }

    //private Electronics() {
    //}

    public double itemPrice() {
        return price;
    }

    public String itemName() {
        return name;
    }

    public static class Builder {

        private String id;
        private double price;
        private String name;
        private List<Tablets> tablet;
        private List<Cellphones> cellphones;
        private List<Storage> storage;
        private List<Laptops> laptops;
        private List<Peripheral> peripheral;

        public Builder() {
        }

        public Builder(double price, String name) {
            this.price = price;
            this.name = name;
        }

        public Builder peripheral(List<Peripheral> value) {
            peripheral = value;
            return this;
        }

        public Builder laptops(List<Laptops> value) {
            laptops = value;
            return this;
        }

        public Builder storage(List<Storage> value) {
            storage = value;
            return this;
        }

        public Builder tablets(List<Tablets> value) {
            tablet = value;
            return this;
        }

        public Builder cellphones(List<Cellphones> value) {
            cellphones = value;
            return this;
        }

        public Builder id(String value) {
            id = value;
            return this;
        }

        public Electronics build() {
            return new Electronics(this);
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

        Electronics itemsImpl = (Electronics) o;

        if (!id.equals(itemsImpl.id)) {
            return false;
        }

        return true;
    }

    public String getID() {
        return id;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
