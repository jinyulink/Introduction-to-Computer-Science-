import java.lang.reflect.Array;
import java.util.*;
// package midterm01;

abstract class Pancake {
    public abstract String getName();
    public abstract int getPrice();
}

class SweetPancake extends Pancake {
    @Override
    private Map<String, Integer> ingredents = new HashMap<String, Integer>();
    private ArrayList<String> selectedIngredients = new ArrayList<String>();
    private int price = 0;

    public SweetPancake(ArrayList<String> selectedIngredients){
        ingredents.put("Chocolate", 12);
        ingredents.put("Honey", 12);
        ingredents.put("Caramel", 16);
        ingredents.put("Matcha", 20);
        ingredents.put("Blueberry", 20);
        this.selectedIngredients = selectedIngredients;
    } 

    public String getName() {
        // TODO: Implement the sorting and formatting of ingredients

    }

    @Override
    public int getPrice() {
        // TODO: Implement the price calculation
        ArrayList<Integer> priceList = new ArrayList<Integer>();
        for(String ingredient : selectedIngredients){
            priceList.add(ingredents.get(ingredient));
        }
        Collections.sort(priceList, Collections.reverseOrder());
        for(int i = 0; i < priceList.size(); i++){
            if(i == 0)  price += priceList.get(0);
            else if(i == 1) price += priceList.get(1) / 2;
            else if(i == 2) price += priceList.get(2) / 4;
        }
    }
}

class SavoryPancake extends Pancake {
    @Override
    private Map<String, Integer> ingredents = new HashMap<String, Integer>();
    private ArrayList<String> selectedIngredients = new ArrayList<String>();

    public SavoryPancake(ArrayList<String> selectedIngredients){
        ingredents.put("Corn", 10);
        ingredents.put("Ham", 15);
        ingredents.put("Bacon", 20);
        ingredents.put("Tuna", 20);
        ingredents.put("SmokedChicken", 30);
        this.selectedIngredients = selectedIngredients;
    }
    public String getName() {
        // TODO: Implement the sorting and formatting of ingredients
    }

    @Override
    public int getPrice() {
        // TODO: Implement the price calculation
    }
}

class OrderDetails extends Pancake {
    // You need to establish an aggregation relationship here.
    // It means using Pancake as your data type.

    private ArrayList<Pancake> orderList = new ArrayList<Pancake>();

    public OrderDetails(ArrayList<Pancake> orderList){
        this.orderList = orderList;
    }

    public void printOrder() {
        // TODO: Implement the printer of Receipt
    }

    @Override
    public String getName() {
        // TODO: Implement the sorting and formatting of ingredients
    }

    @Override
    public int getPrice() {
        // TODO: Implement the total price calculation
    }

}

public class E04_110403518 {
    public static void main(String[] args) {
        // TODO:
        // Create material tables.
        // You may use any data structure to store your materials.
        // Implement your main function.
        /* 
        SweetPancake 
        "Chocolate" 12
        "Honey" 12
        "Caramel" 16
        "Matcha" 20
        "Blueberry" 20

        SavoryPancake 
        "Corn" 10
        "Ham" 15
        "Bacon" 20
        "Tuna" 20
        "SmokedChicken" 30
        */

        // Suggestion : Print Receipt in orderDetails.printOrder()
        // You may modify it.
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ArrayList<Pancake> orderList = new ArrayList<Pancake>();
        for(int i = 0; i < n; i++){
            String type = scn.next();
            if(type.equals("Sweet")){
                int quantity = scn.nextInt();
                ArrayList<String> selectedIngredients = new ArrayList<String>();
                for(int j = 0; j < quantity; j++){
                    String ingredient = scn.next();
                    selectedIngredients.add(ingredient);
                }
                SweetPancake sweetPancake = new SweetPancake(selectedIngredients);
                orderList.add(sweetPancake);
            }
            else if(type.equals("Savory")){
                int quantity = scn.nextInt();
                ArrayList<String> selectedIngredients = new ArrayList<String>();
                for(int j = 0; j < quantity; j++){
                    String ingredient = scn.next();
                    selectedIngredients.add(ingredient);
                }
                SavoryPancake savoryPancake = new SavoryPancake(selectedIngredients);
                orderList.add(savoryPancake);
            }
        }
        scn.close();
        OrderDetails orderDetails = new OrderDetails(orderList);
        System.out.println("---Tin House Pancake Receipt---");
        orderDetails.printOrder();
    }
}

