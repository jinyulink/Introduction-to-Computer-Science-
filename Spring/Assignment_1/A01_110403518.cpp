/*
Assignment 01
Name: 林晉宇
Student Number: 110403518
Course 2024-CE1002-B
*/
#include<iostream>

using namespace std;

class Time{
public:
    Time(long long int totalSeconds) : totalSecond(totalSeconds) { //constructor 
        convertTime();
    }
    void printDateTime() {
        printf("%02d/%02d/%04d %02d:%02d:%02d\n", month, day, year, hour, minute, second);
    }
private:
    long long int totalSecond; // range from 1 ~ 10^12
    static const int baseYear = 1987, baseMonth = 8, baseDay = 30;
    long long int year, month, day, hour, minute, second; // Variables to store the converted date and time
    void convertTime() {
        int daysInMonth[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        long long int days = totalSecond / (24 * 60 * 60);
        second = totalSecond % 60;
        minute = (totalSecond / 60) % 60;
        hour = (totalSecond / (60 * 60)) % 24;

        year = baseYear;
        month = baseMonth;
        day = baseDay;

        while (days > 0) { 
            if (days >= daysInMonth[month - 1] - day) { // 如果剩餘的天數大於或等於當前月份的剩餘天數
                days -= daysInMonth[month - 1] - day; 
                month++; 
                if (month > 12) { // 如果月份超過12，表示進入新的一年
                    month = 1; 
                    year++; 
                    daysInMonth[1] = isLeapYear(year) ? 29 : 28; 
                }
                day = 0; // 重置天數為0，進入新的一個月
            } else {
                day += days; // 如果剩餘的天數小於當前月份的剩餘天數，則直接將剩餘的天數加到當前的日期上
                break; 
            }
        }

    }

    bool isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
};

int main(){
    long long int totalSeconds;
    cin >> totalSeconds;
    Time time(totalSeconds);
    time.printDateTime();
    return 0;
}
