import java.util.*;
public class Coach {
    private String name;
    private String[] studentlist = new String [10];
    private Schedule schedule;
    
    public Coach(String name){
        this.name = name;
        this.schedule = new Schedule();
    }
    
    public boolean is_StudentList_Filled() {
        for (String student : studentlist) {
            if (student == null) {
                return false;
            }
        }
        return true;
    }

    public void Add_to_Coach_Schedule(int day, int time, String name){
        schedule.Add_to_Schedule(day, time, name);
    }

    public String get_Coach_name(){
        return name;
    }

    public void Add_Student(String newStudent) {
        for (int i = 0; i < studentlist.length; i++) {
            if (studentlist[i] == null) {
                studentlist[i] = newStudent;
                break;
            }
        }
    }

    public void Print_free_time(int day) {
        for(int j = 0; j < 12; j++){
            if(schedule.Schedule_Check(day, j) == true){ // 沒課
                switch(day)
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
                System.out.println("Period " + (j + 1)); 
            }
        }
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