package org.example.repositories;

import org.example.models.Product;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * @author Roman Netesa
 *
 */
public class ProductRepository {
    private List<Product> products = new ArrayList<Product>();

    public ProductRepository(List<Product> products) {
        this.products = products;
    }

    public ProductRepository() {

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
