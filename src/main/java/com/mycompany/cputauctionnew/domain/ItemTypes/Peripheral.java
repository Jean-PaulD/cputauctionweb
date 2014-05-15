/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

/**
 *
 * @author Jean-Paul
 */
public class Peripheral {

    private String id;
    private String brand;
    private double price;
    private String name;

    private Peripheral(Peripheral.Builder builder) {
    }

    public String getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private String id;
        private String brand;
        private double price;
        private String name;

        public Builder() {
        }

        public Builder(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public Peripheral.Builder id(String value) {
            id = value;
            return this;
        }

        public Peripheral build() {
            return new Peripheral(this);
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

        Peripheral peripheral = (Peripheral) o;

        if (!id.equals(peripheral.id)) {
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
