package assignment;
/*
 * Assignment 06
 * Name: 李倬安
 * Student Number: 110403516
 * Course 2024-CE1002-資工3A
 */

import java.util.*;

public class A06_110403516 {
    public static class InputNegativeException extends Exception {// set a new exception class for negative input
        public InputNegativeException(String message) {
            super(message);// call the constructor of the parent class
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String userinput = sc.next();
        ArrayList<String> Cart = new ArrayList<String>();// create a list to store the flower name
        ArrayList<Integer> FlowerList = new ArrayList<Integer>();// create a list to store the flower amount
        Map<String, Integer> FlowerStore = new LinkedHashMap<String, Integer>();// the map to store whole flower store
        FlowerStore.put("Rose", 100);// set the original amount of the flower
        FlowerStore.put("Tulip", 100);
        FlowerStore.put("Sunflower", 100);
        FlowerStore.put("Lily", 100);
        FlowerStore.put("Daisy", 100);
        FlowerStore.put("Orchid", 100);
        FlowerStore.put("Peony", 100);
        FlowerStore.put("Carnation", 100);
        while (!userinput.equals("Checkout")) {
            if (userinput.equals("Cart")) {
                if (Cart.size() == 0) {
                    System.out.println("Cart is empty.");// if the cart is empty, print this
                } else {
                    for (int i = 0; i < Cart.size(); i++) {
                        System.out.println((i + 1) + ". " + Cart.get(i) + ": " + FlowerList.get(i));// print the flower and the amount in the cart
                    }
                }
            } else if (userinput.equals("Collect")) {
                String flowername = sc.next();
                System.out.println(flowername + ": " + FlowerStore.get(flowername) + " available");// print the amount of the flower
                int floweramount = 0;
                try {
                    floweramount = sc.nextInt();
                    if (floweramount < 0) {
                        throw new InputNegativeException("Please enter a legal number.");// throw the exception to the self-desgin class if the input is negative
                    }
                    if (Cart.contains(flowername)) {
                        int index = Cart.indexOf(flowername);// get the index of the flower in the cart
                        FlowerList.set(index, FlowerList.get(index) + floweramount);// add the amount to the flower in the cart
                    } else {
                        Cart.add(flowername);// add the flower to the cart
                        FlowerList.add(floweramount);// add the amount to the flower in the cart
                    }
                    FlowerStore.put(flowername, FlowerStore.get(flowername) - floweramount);// update the amount of the flower in the store
                    System.out.println("Collect successful.");// print the successful message
                } catch (InputNegativeException e) {// catch the exception if the input is negative
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {// catch the exception if the input is not a number
                    System.out.println("Please enter a legal number.");
                }
            } else if (userinput.equals("Delete")) {
                String TempFlower = "";
                int TempAmount = 0;
                int deleteindex = sc.nextInt();
                try {
                    if (deleteindex > Cart.size() || deleteindex < 1) {// if the index is out of range, throw the exception
                        throw new IndexOutOfBoundsException();// throw the exception
                    }
                    TempFlower = Cart.get(deleteindex - 1);// store the flower name and the amount before delete
                    TempAmount = FlowerList.get(deleteindex - 1);
                    Cart.remove(deleteindex - 1);// delete the flower and the amount
                    FlowerList.remove(deleteindex - 1);
                    FlowerStore.put(TempFlower, FlowerStore.get(TempFlower) + TempAmount);// update the amount of the flower in the store
                    System.out.println("Delete successful.");
                } catch (IndexOutOfBoundsException e) {// catch the exception if the index is out of range
                    System.out.println("Out of range.");
                }
            }
            userinput = sc.next();
        }
        System.out.println("===Receipt===");
        for (int i = 0; i < Cart.size(); i++) {
            System.out.println((i + 1) + ". " + Cart.get(i) + ": " + FlowerList.get(i));// print the flower and the amount in the cart
        }
        System.out.println("===Inventory===");
        for (int i = 0; i < FlowerStore.size(); i++) {
            System.out.println(
                    FlowerStore.keySet().toArray()[i] + ": " + FlowerStore.values().toArray()[i] + " available");// print the flower and the amount in the store
        }

        sc.close();
    }
}
