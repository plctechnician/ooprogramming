package oop.generics.exercises.shop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShopTest {
    @Test
    void SingleTypeSingleObject() {
        Shop<Fruit> fruitShop = new Shop<>();
        fruitShop.buy(new Fruit());
        assertEquals(List.of(new Fruit()), fruitShop.getItems());
        assertEquals(new Fruit(), fruitShop.sell());
    }

    @Test
    void SingleTypeCollections() {
        Shop<Fruit> fruitShop = new Shop<>();
        fruitShop.buy(List.of(new Fruit(), new Fruit(), new Fruit()));
        assertEquals(List.of(new Fruit(), new Fruit(), new Fruit()), fruitShop.getItems());
        List<Fruit> fruitList = new ArrayList<>();
        fruitShop.sell(fruitList, 3);
        assertEquals(List.of(new Fruit(), new Fruit(), new Fruit()), fruitList);
    }

    @Test
    void SubTypesSingleObject() {
        Shop<Fruit> fruitShop = new Shop<>();
        fruitShop.buy(new Orange());
        assertEquals(List.of(new Orange()), fruitShop.getItems());
        Product product = fruitShop.sell();
        assertEquals(new Orange(), product);
    }

    @Test
    void SubTypesCollections() {
        Shop<Fruit> fruitShop = new Shop<>();
        List<Orange> orangeList = new ArrayList<>(List.of(new Orange(), new Orange(), new Orange()));
        fruitShop.buy(orangeList);
        assertEquals(List.of(new Orange(), new Orange(), new Apple()), fruitShop.getItems());
        List<Product> productList = new ArrayList<>();
        fruitShop.sell(productList, 3);
        assertEquals(List.of(new Orange(), new Orange(), new Apple()), productList);
    }
}