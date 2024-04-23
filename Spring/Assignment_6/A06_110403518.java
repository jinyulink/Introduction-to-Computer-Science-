/*
Assignment 06
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
package assignment;

import java.util.*;

public class A06_110403518 {
    public static class InputNegativeException extends Exception {
        public InputNegativeException(String message) {
            super(message);
        }
    }

    public static class Flower {
        private String name;
        private int quantity;

        public Flower(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }
    }

    public static class Cart {
        private ArrayList<Flower> flowers;

        public Cart() {
            this.flowers = new ArrayList<Flower>();
        }

        public void addFlower(Flower flower) {
            boolean found = false;
            for (Flower f : this.flowers) {
                if (f.name.equals(flower.name)) {
                    f.quantity += flower.quantity;
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.flowers.add(flower);
            }
        }

        public Flower deleteFlower(int index) {
            try {
                if(index >= 0 && index < this.flowers.size()) { // check if the index is in the range
                    Flower flower = this.flowers.get(index);
                    this.flowers.remove(index);
                    System.out.println("Delete successful.");
                    return flower;
                }
                else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException e) { // catch the exception
                System.out.println("Out of range.");
                return null;
            }
        }

        public ArrayList<Flower> getFlowers() {
            return this.flowers;
        }

        public void printCart() {
            if(this.flowers.size() == 0) { // check if the cart is empty
                System.out.println("Cart is empty.");
            }
            else {
                for (int i = 0; i < this.flowers.size(); i++) {
                    Flower flower = this.flowers.get(i);
                    System.out.println(i + 1 + ". " + flower.name + ": " + flower.quantity);
                }
            }
        }
    }

    public static class Shop {
        private Cart cart;
        ArrayList<Flower> availableFlowers = new ArrayList<Flower>();

        public Shop() {
            this.cart = new Cart();
            this.availableFlowers = new ArrayList<Flower>();
            String[] flowerNames = {"Rose", "Tulip", "Sunflower", "Lily", "Daisy", "Orchid", "Peony", "Carnation"}; // the available flowers
            for (String name : flowerNames) {
                this.availableFlowers.add(new Flower(name, 100)); // add the flowers to the inventory
            }
        }

        public void printCart() {
            this.cart.printCart();
        }

        public void printFlower(String name) {
            for (Flower flower : this.availableFlowers) { // print the available flowers
                if (flower.name.equals(name)) {
                    System.out.println(flower.name + ": " + flower.quantity + " available");
                    return;
                }
            }
        }

        public void collectFlower(String name, int quantity) {
            for (Flower flower : this.availableFlowers) {
                if (flower.name.equals(name)) {
                    // System.out.println(flower.name + ": " + flower.quantity + " available");
                    if (flower.quantity >= quantity) { // check if the quantity is enough
                        flower.quantity -= quantity;
                        System.out.println("Collect successful.");
                        this.cart.addFlower(new Flower(name, quantity));
                    } else {
                        throw new IllegalArgumentException("Please enter a legal number.");
                    }
                    return;
                }
            }
        }

        public void deleteFlower(int index) { // delete the flower from the cart
            Flower flower = this.cart.deleteFlower(index);
            if(flower == null)  return;
            for (Flower availableFlower : this.availableFlowers) { // add the flower back to the inventory
                if (availableFlower.name.equals(flower.name)) {
                    availableFlower.quantity += flower.quantity;
                    return;
                }
            }
        }

        public void checkout() { // checkout the cart
            System.out.println("===Receipt===");
            this.cart.printCart();
            System.out.println("===Inventory===");
            for (Flower flower : this.availableFlowers) {
                System.out.println(flower.name + ": " + flower.quantity + " available");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        Shop shop = new Shop();
        while(true) {
            if(command.equals("Cart")){
                shop.printCart();
            }
            else if(command.equals("Collect")){
                String name = sc.next();
                shop.printFlower(name);
                try { // catch the exception
                    int quantity = sc.nextInt();
                    if (quantity < 0) {
                        throw new InputNegativeException("Please enter a legal number."); // throw the negative input exception
                    }
                    shop.collectFlower(name, quantity);// collect the flower
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a legal number.");
                } catch (InputNegativeException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if(command.equals("Delete")){
                int identity = sc.nextInt();   
                shop.deleteFlower(identity - 1);
            }
            else if(command.equals("Checkout")){
                shop.checkout();
                break;
            }
            command = sc.next();
        }
    }
}