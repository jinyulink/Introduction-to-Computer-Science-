import java.util.*;
public class Schedule {
    private ArrayList<int[]> schedule;
    private ArrayList<String[]> name; 
    public Schedule(){
        schedule = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int[] daySchedule = new int[12];
            Arrays.fill(daySchedule, 0);
            schedule.add(daySchedule);
        }
        name = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String[] names = new String[12];
            Arrays.fill(names, "");
            name.add(names);
        }
    }
    public Boolean Schedule_Check(int day, int time){
        if(schedule.get(day)[time] == 1){
            return false; // 有課
        }
        else return true; // 沒課
    }
    public void Add_to_Schedule(int day, int time, String name){
        
        this.schedule.get(day)[time] = 1;
        this.name.get(day)[time] = name;
    }
    public String get_Name(int day, int time){
        return this.name.get(day)[time];
    }
}