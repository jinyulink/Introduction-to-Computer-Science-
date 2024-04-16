package midterm01;
import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;

public class E01_110403518 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String birthDay = scn.next(); //"Saturday"
        long totalSecond = scn.nextLong(); //1 <= N <= 10^12
        scn.close();
        TAD tad = new TAD(totalSecond, birthDay);
        tad.calculate();
        tad.printOutput();
    }
    public static class TAD{
        private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        private Map<String, Integer> dayMap = new HashMap<>(){{
            put("Sunday", 0);
            put("Monday", 1);
            put("Tuesday", 2);
            put("Wednesday", 3);
            put("Thursday", 4);
            put("Friday", 5);
            put("Saturday", 6);
        }};
        private long[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        private long totalSecond;
        private long second, minute, hour, day, month, year;
        private String dayOfWeek;
        private static int ogYear = 2000, ogMonth = 1, ogDay = 1, ogHour = 0, ogMinute = 0, ogSecond = 0;
        private static String ogBirthday;
        public TAD(Long totalSecond, String birthDay){
            this.totalSecond = totalSecond;
            this.ogBirthday = birthDay;
        }
        public void calculate(){
            long days = totalSecond / (24 * 60 * 60);
            second = totalSecond % 60;
            minute = (totalSecond / 60) % 60;
            hour = (totalSecond / (60 * 60)) % 24;
            year = ogYear;
            month = ogMonth;
            day = ogDay;
            int index = (dayMap.get(ogBirthday) + (int)days) % 7;
            dayOfWeek = this.days[index];
            
            while(days > 0){
                if(days > monthDays[(int)month]){
                    days -= monthDays[(int)month];
                    month++;
                    if(month > 12){
                        month = 1;
                        year ++;
                        monthDays[2] = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
                    }
                    day = 0;
                } else {
                    day += days;
                    break;
                }
            }
        }
        public static String getTransTime(String timeStr) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/M/d H:m:s");
            LocalDateTime date = LocalDateTime.parse(timeStr, df);
            DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String transTime = f2.format(date);
     
            return transTime;
        }
        public void printOutput(){
            String res = (Long.toString(year) + "/" + Long.toString(month) + "/" + Long.toString(day) + " " + Long.toString(hour) + ":" + Long.toString(minute) + ":" + Long.toString(second));
            System.out.println(getTransTime(res) + " is " + dayOfWeek);
        }
    }
}