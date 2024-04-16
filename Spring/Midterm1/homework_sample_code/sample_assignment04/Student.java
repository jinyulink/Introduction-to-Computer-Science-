import java.util.*;
public class Student {
    private String name;
    private Schedule schedule;
    private ArrayList<String[]> Lesson_Coach;
    public Student(String name){
        this.name = name;
        this.schedule = new Schedule();
    }

    public Boolean Check_Schedule(int day, int time){
        if(schedule.Schedule_Check(day, time) == false){ // 有課
            return false;
        }
        else return true;
    }

    public void Set_Schedule(int day, int time, String name){
        schedule.Add_to_Schedule(day, time, name);
    }

    public String Get_Student_Name(){
        return name;
    }

    public void Print_Schedule() {
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 12; j++){
                if(schedule.Schedule_Check(i, j) == false){ // 有課
                    switch(i)
                    {
                        case 0 :
                            System.out.print("Mon. "); 
                        break;
                        case 1:
                            System.out.print("Tue. "); 
                        break;
                        case 2:
                            System.out.print("Wed. ");
                        break;
                        case 3:
                            System.out.print("Thr. ");
                        break;
                        case 4:
                            System.out.print("Fri. ");
                        break;
                        case 5:
                            System.out.print("Sat. ");
                        break;
                        case 6:
                            System.out.print("Sun. ");
                        break;
                    }
                    System.out.print("Period " + (j + 1)); 
                    System.out.println(" " + schedule.get_Name(i, j)); 
                }
            }
        }
    }
}