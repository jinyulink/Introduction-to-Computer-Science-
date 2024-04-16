/*
Assignment 05
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
// UTF-8

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Comparator;

public class A05_110403518 {
    public static abstract class Character {
        private String name;
        private String type;

        public Character(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() { // return player's name
            return name;
        }

        public String getType() {
            return type;
        }

        //  return player's or team's attack
        public abstract int attack();
    
        // return all teammate in String type
        public abstract String teammate();
    }
    
    public static class Warrior extends Character {
        public Warrior(String name, String type) {
            super(name, type);
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
        public Bowmen(String name, String type) {
            super(name, type);
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
        public Magician(String name, String type) {
            super(name, type);
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
        public Thief(String name, String type) {
            super(name, type);
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
        public Pirate(String name, String type) {
            super(name, type);
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
        private int teamMember;
        private ArrayList<Character> team = new ArrayList<Character>();
        private Team(int teamMember, ArrayList<Character> team) { // constructor
            super(null, "team");
            this.teamMember = teamMember;
            this.team = team;
        }

        @Override
        public int attack() {
            int totalAttack = 0;
            HashMap<String, Integer> counts = new HashMap<String, Integer>(); // store the number of each class
            for (Character character : team) { // calculate the total attack of the team
                String className = character.getType();
                if (!counts.containsKey(className)) counts.put(className, 0);
                counts.put(className, counts.get(className) + 1);
                int baseAttack = character.attack();
                if (counts.get(className) > 1)  baseAttack *= 2;
                totalAttack += baseAttack;
            }
            return totalAttack;
        }

        @Override
        public String teammate() { // return all teammate in String type
            StringBuilder teammates = new StringBuilder();
            for (int i = 0; i < team.size(); i++) {
                Character character = team.get(i);
                teammates.append(character.getType()).append(" : ").append(character.teammate());
                if (i < team.size() - 1) {
                    teammates.append("\n");
                }
            }
            return teammates.toString();
        }
    }
    
    public static void PrintRank(ArrayList<Character> arr) {

        Collections.sort(arr, new Comparator<Character>() { // sort the team by type and name
            @Override
            public int compare(Character o1, Character o2) {
                return o2.attack() - o1.attack();
            } // lambda expression
        }); // sort the team by attack in descending order 

        for(int i = 0; i < arr.size(); i++) {
            System.out.println("Tier " + (i + 1) + " team:");
            System.out.println(arr.get(i).teammate());
            System.out.print("Team " + "BUFF : ");
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
                    Warrior w = new Warrior(name, "Warrior");
                    team.add(w);
                }else if(type.equals("Bowmen")){
                    // add Bowmen object to team
                    String name = sc.next();
                    Bowmen b = new Bowmen(name, "Bowmen");
                    team.add(b);
                }else if(type.equals("Magician")){
                    // add Magician object to team
                    String name = sc.next();
                    Magician ma = new Magician(name, "Magician");
                    team.add(ma);
                }else if(type.equals("Thief")){
                    // add Thief object to team
                    String name = sc.next();
                    Thief t = new Thief(name, "Thief");
                    team.add(t);
                }else if(type.equals("Pirate")){
                    // add Pirate object to team
                    String name = sc.next();
                    Pirate p = new Pirate(name, "Pirate");
                    team.add(p);
                }
            }
            Collections.sort(team, new Comparator<Character>() { // sort the team by type and name
                @Override
                public int compare(Character c1, Character c2) {
                    int typeComparison = c1.getType().compareTo(c2.getType());
                    if (typeComparison != 0) {
                        return typeComparison;
                    } else {
                        return c1.getName().compareTo(c2.getName());
                    }
                }
            });
            Team t = new Team(m, team);
            teams.add(t);
        }
        sc.close();
        PrintRank(teams);
    }
}