/*
Assignment 04
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
//utf-8
// package assignment;

import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class A04_110403518 {
    public static void main(String[] args) {
        Map<String, Coach_110403518> coachMap = new TreeMap<>(); // 用於讓name map到object
        Map<String, Student_110403518> studentMap = new TreeMap<>();
        int n;
        String coach_name, student_name;
        int weekday;
        int time_selected;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            coach_name = scanner.next();
            coachMap.put(coach_name, new Coach_110403518(coach_name));
        }
        while(!(student_name = scanner.next()).equals("END")){
            Student_110403518 student;
            if (!studentMap.containsKey(student_name)) {
                student = new Student_110403518(student_name);
                studentMap.put(student_name, student);
            } 
            else {
                student = studentMap.get(student_name);
            }
            coach_name = scanner.next();
            Coach_110403518 coach = coachMap.get(coach_name);
            if(coach.checkFull() == true){ // 檢查coach是否已經滿了
                continue;
            }
            weekday = scanner.nextInt();
            coach.getFreeTime(weekday);
            time_selected = scanner.nextInt();
            student.book(weekday, time_selected, coach_name);
            coach.book(weekday, time_selected, student_name);
        }
        System.out.println();
        for(String key : coachMap.keySet()){ // 依照名字順序印出
            System.out.println(key);
            coachMap.get(key).printBooked();
        }
        System.out.println();
        for(String key : studentMap.keySet()){
            System.out.println(key);
            studentMap.get(key).printBooked();
        }
    }
}