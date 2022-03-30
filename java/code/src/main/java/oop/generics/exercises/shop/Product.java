package oop.generics.exercises.shop;

import java.util.Objects;

public class Product {
    public String description;

    public Product() {
        super();
        description = "A product";
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(description, product.description);
    }

    @Override
    public String toString() {
        return description;
    }
}
