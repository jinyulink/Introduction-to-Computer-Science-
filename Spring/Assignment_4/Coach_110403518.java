/*
Assignment 04
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-3B
*/
//utf-8

// package assignment;

public class Coach_110403518 {
    private String name;
    private Schedule_110403518 schedule;
    private int count = 0; // 計算已經預約了幾個時段
    public Coach_110403518(String name){
        this.name = name;
        this.schedule = new Schedule_110403518();
    }
    public void getFreeTime(int weekday){
        String[] weekdays = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for(int j = 1; j < 13; j++){ // 一天有12個時段(1~12)
            if(schedule.isFree(weekday, j)){
                System.out.println(weekdays[weekday-1] + ". Period " + (j));
            }
        }
    }
    public Boolean checkFull(){
        if(count >= 10){ //每個教練最多能指導10個時段
            System.out.println("This coach's class is full, please input again.");
        }
        return count >= 10;
    }
    public void book(int weekday, int time, String student_name){ // 預約時段
        if(schedule.isFree(weekday, time)){
            schedule.book(weekday, time, student_name);
            count++;
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
