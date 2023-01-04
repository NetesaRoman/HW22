package org.example;

import org.example.models.Cart;
import org.example.models.Product;
import org.example.repositories.ProductRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Scanner;

/*
 *
 * @author Roman Netesa
 *
 */
public class Main {
    public static void main(String[] args) {
        String configPath = "src/main/resources/ApplicationContext.xml";
        ApplicationContext context = new FileSystemXmlApplicationContext(configPath);
        System.out.println(context.getApplicationName());
        Cart cart = context.getBean("cart", Cart.class);
        cart.showAll();
        Scanner sc = new Scanner(System.in);
        int commandID = 1;

        while (commandID != 0) {
            System.out.println("1 - add to repo");
            System.out.println("2 - delete from repo");
            System.out.println("3 - show all");
            System.out.println("4 - show by id");
            System.out.println("0 - exit");
            commandID = sc.nextInt();
            switch (commandID) {
                case 1:
                    addToRepo(cart);
                    break;
                case 2:
                    deleteFromRepo(cart);
                    break;
                case 3:
                    cart.showAll();
                    break;
                case 4:
                    showByID(cart);
                    break;
                default:
                    System.out.println("Unknow command");
                    break;
            }
        }
    }

    public static void addToRepo(Cart cart) {
        Scanner sc = new Scanner(System.in);
        int id;
        String name;
        double price;
        System.out.println("Enter product ID: ");
        id = sc.nextInt();
        System.out.println("Enter product price: ");
        price = sc.nextDouble();
        System.out.println("Enter product name: ");
        sc = new Scanner(System.in);
        name = sc.nextLine();


        cart.add(new Product(id, name, price));
    }

    public static void deleteFromRepo(Cart cart){
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter product ID: ");
        id = sc.nextInt();

        cart.delete(id);
    }

    public static void showByID(Cart cart){
        Scanner sc = new Scanner(System.in);
        int id;

        System.out.println("Enter product ID: ");
        id = sc.nextInt();
        cart.showByID(id);
    }
}
