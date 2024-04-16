import java.util.*;
public class a04
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int coachNum = scanner.nextInt(); // coach num
        scanner.nextLine(); // 吸收掉nextInt()方法留下的换行

/* -----------------------------------------------------------
    輸入 coach ，建立起 coach 的陣列並儲存
----------------------------------------------------------- */
        Coach[] coachList = new Coach[coachNum];
        for(int i = 0; i < coachNum; i++){
            String coachName = scanner.nextLine(); // coach name
            Coach coach = new Coach(coachName);
            coachList[i] = coach;
        }
        
/* -----------------------------------------------------------
    直到輸入 END 才結束
    輸入 student name ，並確認是否已經建立好其課表，若無才新建
    教練名，確認該教練有沒有空位
    若有，則印出教練目前可預約的時間並選擇，選擇後確定有無撞期
        若有，則報錯，並重新輸入學生名
    若無，告知教練已收滿人，重新輸入學生名
----------------------------------------------------------- */
        ArrayList<Student> students = new ArrayList<Student>();
        String studentName = scanner.nextLine();
        while(!studentName.equals("END")){
            int temp = -1;
            for(int i = 0; i < students.size(); i++){
                if(students.get(i).Get_Student_Name().equals(studentName)){
                    temp = i;
                    break;
                }
            }
            if(temp != -1){
                String coachName = scanner.nextLine();
                for(int i = 0; i < coachNum; i++){
                    if(coachList[i].get_Coach_name().equals(coachName)){
                        if(!coachList[i].is_StudentList_Filled()){
                            int day = scanner.nextInt();
                            scanner.nextLine();
                            coachList[i].Print_free_time(day - 1);
                            int time = scanner.nextInt();
                            scanner.nextLine();
                            if(students.get(temp).Check_Schedule(day - 1, time - 1) == false){ // 檢查學生時間有無撞期
                                System.out.println("Have a Collision, please input again.");
                                break;
                            }
                            else{
                                coachList[i].Add_Student(studentName);
                                coachList[i].Add_to_Coach_Schedule(day - 1, time - 1, studentName);
                                students.get(temp).Set_Schedule(day - 1, time - 1, coachName);
                            }
                        }
                        else{
                            System.out.println("This coach's class is full, please input again.");
                            break;
                        }
                    }
                }
            }
            else{
                Student student = new Student(studentName);
                String coachName = scanner.nextLine();
                for(int i = 0; i < coachNum; i++){
                    if(coachList[i].get_Coach_name().equals(coachName)){
                        if(!coachList[i].is_StudentList_Filled()){
                            int day = scanner.nextInt();
                            scanner.nextLine();
                            coachList[i].Print_free_time(day - 1);
                            int time = scanner.nextInt();
                            scanner.nextLine();
                            if(student.Check_Schedule(day - 1, time - 1) == false){ // 檢查學生時間有無撞期
                                System.out.println("Have a Collision, please input again.");
                                break;
                            }
                            else{
                                coachList[i].Add_Student(studentName);
                                coachList[i].Add_to_Coach_Schedule(day - 1, time - 1, studentName);
                                student.Set_Schedule(day - 1, time - 1, coachName);
                                break;
                            }
                        }
                        else{
                            System.out.println("This coach's class is full, please input again.");
                            break;
                        }
                    }
                }
                students.add(student);
            }
            studentName = scanner.nextLine();
        }
/* -----------------------------------------------------------
    END 後，依照 ASCII 順序，輸出教練名與課表
    並輸出學生名與課表
----------------------------------------------------------- */
        System.out.println();
        Arrays.sort(coachList, new Comparator<Coach>() {
            public int compare(Coach coach1, Coach coach2) {
                return coach1.get_Coach_name().compareTo(coach2.get_Coach_name());
            }
        });
        Collections.sort(students, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.Get_Student_Name().compareTo(student2.Get_Student_Name());
            }
        });
        for(int i = 0; i < coachList.length; i++){
            System.out.println(coachList[i].get_Coach_name());
            coachList[i].Print_Schedule();
        }
        System.out.println();
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).Get_Student_Name());
            students.get(i).Print_Schedule();
        }
    }
}