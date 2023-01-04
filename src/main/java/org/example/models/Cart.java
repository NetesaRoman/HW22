package org.example.models;

import org.example.repositories.ProductRepository;

/*
 *
 * @author Roman Netesa
 *
 */
public class Cart {
    private ProductRepository pr;

    public Cart(ProductRepository pr) {
        this.pr = pr;
    }

    public Cart() {


    }

    public void add(Product p) {
        pr.getProducts().add(p);
    }

    public void delete(int index) {
        for (Product p : pr.getProducts()) {
            if (index == p.getId()) {
                pr.getProducts().remove(p);
                break;
            }
        }

    }

    public void delete(Product p) {
        pr.getProducts().remove(p);
    }

    public void showByID(int id) {
        boolean found = false;

        for (Product p : pr.getProducts()) {
            if (id == p.getId()) {
                p.showInfo();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found!");
        }
    }

    public void showAll() {
        if (pr.getProducts().size() == 0) {
            System.out.println("Product bin is empty!");
            return;
        }

        for (Product p : pr.getProducts()) {
            p.showInfo();
        }
    }
}
