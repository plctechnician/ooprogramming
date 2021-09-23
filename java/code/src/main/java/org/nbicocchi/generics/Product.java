package org.nbicocchi.generics;

/**
 * A generic product
 *
 * @author Nicola Bicocchi
 */
public class Product {
    public String description;

    public Product() {
        super();
        description = "A product";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
