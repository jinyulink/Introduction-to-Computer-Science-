#include <iostream>
#include <iomanip>

class TimeCalculator {
private:
    struct Time {
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int second;
    };

    Time baseTime;
    long long totalSeconds;

    // 判斷是否為閏年
    bool isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 根據總秒數計算時間
    void calculateTime() {
        int daysInMonth[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        baseTime.second += totalSeconds;

        while (baseTime.second >= 60) {
            baseTime.minute += 1;
            baseTime.second -= 60;
        }
        while (baseTime.minute >= 60) {
            baseTime.hour += 1;
            baseTime.minute -= 60;
        }
        while (baseTime.hour >= 24) {
            baseTime.day += 1;
            baseTime.hour -= 24;
        }
        while (true) {
            int daysInThisMonth = daysInMonth[baseTime.month - 1];
            if (baseTime.month == 2 && isLeapYear(baseTime.year)) {
                daysInThisMonth = 29;
            }
            if (baseTime.day > daysInThisMonth) {
                baseTime.day -= daysInThisMonth;
                baseTime.month += 1;
                if (baseTime.month > 12) {
                    baseTime.month = 1;
                    baseTime.year += 1;
                }
            } else {
                break;
            }
        }
    }

public:
    TimeCalculator(long long seconds) : totalSeconds(seconds) {
        baseTime.year = 1987;
        baseTime.month = 8;
        baseTime.day = 30;
        baseTime.hour = 0;
        baseTime.minute = 0;
        baseTime.second = 0;

        calculateTime();
    }

    void printTime() {
        std::cout << std::setfill('0') << std::setw(2) << baseTime.month << '/'
                  << std::setw(2) << baseTime.day << '/' << baseTime.year << ' '
                  << std::setw(2) << baseTime.hour << ':' << std::setw(2) << baseTime.minute << ':'
                  << std::setw(2) << baseTime.second << std::endl;
    }
};

int main() {
    long long totalSeconds;
    std::cin >> totalSeconds;

    TimeCalculator calculator(totalSeconds);
    calculator.printTime();

    return 0;
}
