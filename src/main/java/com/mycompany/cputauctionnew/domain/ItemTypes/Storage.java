/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cputauctionnew.domain.ItemTypes;

/**
 *
 * @author Jean-Paul
 */
public class Storage {

    private String id;
    private String brand;
    private double price;
    private String name;

    private Storage(Storage.Builder builder) {
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

        public Storage.Builder id(String value) {
            id = value;
            return this;
        }

        public Storage build() {
            return new Storage(this);
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

        Storage storage = (Storage) o;

        if (!id.equals(storage.id)) {
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
