/*
Assignment 05
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
// UTF-8

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;

public class A05_110403518 {
    public static abstract class Character {
        private String name;

        public Character(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        //  return player's or team's attack
        public abstract int attack();
    
        // return all teammate in String type
        public abstract String teammate();
    }
    
    public static class Warrior extends Character {
        // Implement function attack() and teammate()
        public Warrior(String name) {
            super(name);
        }

        @Override
        public int attack() {
            return 40;
        }

        @Override
        public String teammate() {
            return this.getName();
        }
    }
    
    public static class Bowmen extends Character {
        // Implement function attack() and teammate()
        public Bowmen(String name) {
            super(name);
        }

        @Override
        public int attack() {
            return 25;
        }

        @Override
        public String teammate() {
            return this.getName();
        }
    }
    
    public static class Magician extends Character {
        // Implement function attack() and teammate()
        public Magician(String name) {
            super(name);
        }

        @Override
        public int attack() {
            return 30;
        }

        @Override
        public String teammate() {
            return this.getName();
        }
    }
    
    public static class Thief extends Character {
        // Implement function attack() and teammate()
        public Thief(String name) {
            super(name);
        }

        @Override
        public int attack() {
            return 50;
        }

        @Override
        public String teammate() {
            return this.getName();
        }
    }
    
    public static class Pirate extends Character {
        // Implement function attack() and teammate()
        public Pirate(String name) {
            super(name);
        }

        @Override
        public int attack() {
            return 34;
        }

        @Override
        public String teammate() {
            return this.getName();
        }
    }
    
    public static class Team extends Character {
        // Implement aggregation to Character class
        // Implement function attack() and teammate()
        private int teamMember;
        private ArrayList<Character> team = new ArrayList<Character>();
        private Team(int teamMember, ArrayList<Character> team) {
            super("team");
            this.teamMember = teamMember;
            this.team = team;
        }

        @Override
        public int attack() {
            int totalAttack = 0;
            HashMap<String, Integer> counts = new HashMap<String, Integer>();
            for (Character character : team) {
                totalAttack += character.attack();
                String className = character.getName();
                if(counts.containsKey(className)) {
                    totalAttack += character.attack() * counts.get(className);
                    counts.put(className, counts.get(className) + 1);
                } else {
                    counts.put(className, 1);
                }
            }
            return totalAttack;
        }

        @Override
        public String teammate() {
            StringBuilder teammates = new StringBuilder();
            for (Character character : team) {
                teammates.append(character.teammate()).append(" : ").append(character.teammate()).append("\n");
            }
            return teammates.toString();
        }
    }
    
    public static void PrintRank(ArrayList<Character> arr) {
        /*
         *  You can add other code here
         */
        Collections.sort(arr, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2.attack() - o1.attack();
            } // lambda expression
        }); // sort the team by attack in descending order 
    
         // use for loop or foreach to access the element in parameter
         // Do not remove the following two instructions in for loop or foreach
         // But you can add other code in it
         for(int i = 0; i < arr.size(); i++) {
            System.out.println("Tier " + (i + 1) + " team:\n");
            System.out.println(arr.get(i).teammate());
            System.out.println("Team " + " BUFF : ");
            System.out.println(arr.get(i).attack());
            System.out.println();
         }
    }    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of teams
        ArrayList<Character> teams = new ArrayList<Character>();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt(); // number of players in each team
            ArrayList<Character> team = new ArrayList<Character>();
            for(int j = 0; j < m; j++){
                String type = sc.next();
                if(type.equals("Warrior")){
                    // add Warrior object to team
                    String name = sc.next();
                    Warrior w = new Warrior(name);
                    team.add(w);
                }else if(type.equals("Bowmen")){
                    // add Bowmen object to team
                    String name = sc.next();
                    Bowmen b = new Bowmen(name);
                    team.add(b);
                }else if(type.equals("Magician")){
                    // add Magician object to team
                    String name = sc.next();
                    Magician ma = new Magician(name);
                    team.add(ma);
                }else if(type.equals("Thief")){
                    // add Thief object to team
                    String name = sc.next();
                    Thief t = new Thief(name);
                    team.add(t);
                }else if(type.equals("Pirate")){
                    // add Pirate object to team
                    String name = sc.next();
                    Pirate p = new Pirate(name);
                    team.add(p);
                }
            }
            Team t = new Team(m, team);
        }
        sc.close();
        PrintRank(teams);
    }
}