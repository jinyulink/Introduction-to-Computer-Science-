/*
Assignment 04
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
//utf-8
// package assignment;

public class Student_110403518 {
    private String name;
    private Schedule_110403518 schedule;
    public Student_110403518(String name){ // constructor
        this.name = name;
        this.schedule = new Schedule_110403518();
    }
    public void book(int weekday, int time, String coach_name){ // 預約時段
        if(schedule.isFree(weekday, time)){
            // System.out.println("Booked successfully");
            schedule.book(weekday, time, coach_name);
        }else{
            System.out.println("Have a Collision, please input again.");
        }
    }
    public void printBooked(){ // 印出已經預約的時段
        String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for(int i = 1; i < 8; i++){
            for(int j = 1; j < 13; j++){
                if(!schedule.isFree(i, j)){
                    System.out.println(weekdays[i-1] + ". Period " + (j) + " " + schedule.getBookedBy(i, j));
                }
            }
        }
    }
}
