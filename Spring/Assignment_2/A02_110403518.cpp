/*
Assignment 02
Name: �L�ʦt
Student Number: 110403518
Course 2024-CE1002-3B
*/
#include<iostream>
#include<unordered_map>
#include<set>
#include<algorithm>
using namespace std;

class Course {
    friend class Student;
public:
    Course() {} // default constructor�A�]��unordered_map�b���J�ɡA�|���s�ŧi�s��object�A�|�Ψ�default constructor
    // https://stackoverflow.com/questions/29826155/why-a-default-constructor-is-needed-using-unordered-map-and-tuple
    Course(string cN, string cT){ // constructor
        courseName = cN;
        courseTime = cT;
    }
    bool operator<(const Course& other) const {
        return courseName < other.courseName; //�C��insert ����course name�Ƨ�
    }
private:
    string courseName;
    string courseTime;
};

class Student {
public:
    Student() {}
    Student(string sN){
        studentName = sN;
    }
    void enrollCourse(Course course){
        courses.insert(course); //�C��insert ����course name�Ƨ�
    }
    void listCourse(){
        cout << studentName << "'s Courses:" << endl;
        for(Course course : courses){
            cout << "-" << course.courseName << endl;
        }
    }
    void checkConflicts(){ //O(n^2)
        cout << studentName << "'s Conflicts:" << endl;
        bool hasConflict = false;
        for(Course course : courses){
            for(Course courseTmp : courses){
                if(course.courseName == courseTmp.courseName){
                    continue;
                }
                if(course.courseTime == courseTmp.courseTime){
                    hasConflict = true;
                    cout << "-" << course.courseName << endl;
                    break;
                }
            }
        }
        if(!hasConflict){
            cout << "none" << endl;
        }
    }
private:
    string studentName;
    set<Course> courses;
};

int n;
string command;
unordered_map<string, Course> courseHash; 
unordered_map<string, Student> studentHash;

int main(){
    cin >> n;
    for(int i = 0; i < n; i++){ //��J�ҵ{��T
        string courseName, courseTime;
        cin >> courseName >> courseTime;
        Course courseObj(courseName, courseTime);
        courseHash[courseName] = courseObj;
    }
    while(cin >> command){ //��J���O
        if(command == "EnrollStudent"){
            int courseNumber;
            string studentName;
            cin >> courseNumber >> studentName;
            Student studentObj(studentName);
            for(int i = 0; i < courseNumber; i++){
                string courseName;
                cin >> courseName;
                studentObj.enrollCourse(courseHash[courseName]);
            }
            studentHash[studentName] = studentObj;
            cout << studentName << " Enroll Success." << endl;
        }
        else if(command == "ListCourses"){
            string studentName;
            cin >> studentName;
            if(!studentHash.count(studentName)){
                cout << "Has no " << studentName << "." << endl;
                continue;
            }
            Student studentObj = studentHash[studentName];
            studentObj.listCourse();
        }
        else if(command == "CheckConflicts"){
            string studentName;
            cin >> studentName;
            if(!studentHash.count(studentName)){
                cout << "Has no " << studentName << "." << endl;
                continue;
            }
            Student studentObj = studentHash[studentName];
            studentObj.checkConflicts();
        }
        else if(command == "END"){
            break;
        }
    }
    return 0;
}