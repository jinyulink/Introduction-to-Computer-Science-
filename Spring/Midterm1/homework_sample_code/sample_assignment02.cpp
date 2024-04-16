#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Course; 

class Student {
private:
    string name;
    vector<Course> courses; 

public:
    Student(string _name){
        name = _name;
    }

    string getName() const { 
        return name; 
    } 

    void enrollCourse(const Course& course); 

    void displayCourses() const;

    void displayConflicts() const;
};

class Course {
private:
    string name;
    string time;
    
    friend void Student::displayCourses() const; 
    friend void Student::displayConflicts() const; 
    friend void Student::enrollCourse(const Course& course);

public:
    Course(string _name, string _time){
        name = _name;
        time = _time;
    }

    string getName() const { return name; }

    bool hasOverlapWith(const Course& other) const {
        return time == other.time;
    }
};

void Student::enrollCourse(const Course& course) {
    courses.push_back(course);
    sort(courses.begin(), courses.end(), [](const Course& a, const Course& b) { return a.name < b.name; });
}

void Student::displayCourses() const {
    cout << name << "'s Courses:" << endl;
    for (const Course& course : courses) {
        cout << "-" <<course.name << endl;
    }
}

void Student::displayConflicts() const {
    cout << name << "'s Conflicts:" << endl;
    bool hasConflicts = false;
    for (int i = 0; i <= courses.size() - 1; i++) {
        for (int j = 0; j <= courses.size() - 1; j++) {
            if(courses[i].name == courses[j].name) continue;

            if (courses[i].hasOverlapWith(courses[j])) {
                cout << "-" <<courses[i].name << endl;
                hasConflicts = true;
                break;
            }
        }
    }
    if(!hasConflicts) cout << "none" << endl;
}

int main() {
    int numCourses;
    cin >> numCourses;
    vector<Course> courses;
    for (int i = 0; i < numCourses; ++i) {
        string name, time;
        cin >> name >> time;
        courses.push_back(Course(name, time));
    }

    string command;
    vector<Student> students;
    while (cin >> command) {
        if (command == "EnrollStudent") {
            int numCourses;
            cin >> numCourses;
            string studentName;
            cin >> studentName;
            Student student(studentName);
            for (int i = 0; i < numCourses; ++i) {
                string courseName;
                cin >> courseName;
                for (const Course& course : courses) {
                    if (course.getName() == courseName) {
                        student.enrollCourse(course); 
                        break;
                    }
                }
            }
            students.push_back(student);
            cout << studentName << " Enroll Success." << endl;
        } else if (command == "ListCourses") {
            string studentName;
            cin >> studentName;
            bool hasStudent = false;
            for (const Student& student : students) {
                if (student.getName() == studentName) {
                    student.displayCourses();
                    hasStudent = true;
                    break;
                }
            }
            if(!hasStudent) cout << "Has no " << studentName << "." <<endl;
        } else if (command == "CheckConflicts") {
            string studentName;
            cin >> studentName;
            bool hasStudent = false;
            for (const Student& student : students) {
                if (student.getName() == studentName) {
                    student.displayConflicts();
                    hasStudent = true;
                    break;
                }
            }
            if(!hasStudent) cout << "Has no " << studentName << "." <<endl;
        } else if (command == "END") {
            break;
        }
    }

    return 0;
}
