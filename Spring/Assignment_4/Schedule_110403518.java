/*
Assignment 04
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
//utf-8
// package assignment;

public class Schedule_110403518 {
    private boolean[][] schedule = new boolean[8][13];
    private String[][] bookedBy = new String[8][13];

    public Schedule_110403518(){
        schedule = new boolean[8][13]; // 初始化為false，表示所有時段都是空閒的
        bookedBy = new String[8][13]; // 初始化為null，表示没有人预约
    }

    public boolean isFree(int weekday, int time){
        return !schedule[weekday][time]; // 如果是false的代表該時段是空的
    }

    public void book(int weekday, int time, String name){
        schedule[weekday][time] = true; // 預約成功
        bookedBy[weekday][time] = name; // 記錄是誰預約的
    }

    public String getBookedBy(int weekday, int time){
        return bookedBy[weekday][time]; // 返回是誰預約的
    }
}
