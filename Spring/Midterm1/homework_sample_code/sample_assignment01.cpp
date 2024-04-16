#include <iostream>
#include <iomanip>

using namespace std;

class TAD
{
public:
    TAD(unsigned long long ttsec)
    {
        setting(ttsec);
    }
    void setting(unsigned long long n)
    {
        unsigned long long days[20]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        second = n%60;
        n /= 60;
        minute = n%60;
        n /= 60;
        hour = n%24;
        n /= 24;
        year = 1987;
        if(n < 124){
            for(int i = 8; i <= 12; i++){
                if(i == 8){
                    if(n >= 2){
                        n -= 2;
                    }
                    else{
                        month = i;
                        break;
                    }
                }
                else{
                    if(n >= days[i]){
                        n -= days[i];
                    }
                    else{
                        month = i;
                        break;
                    }
                }
            }
            if(month == 8){
                day = 30 + n;
            }
            else{
                day = n + 1;
            }
        }
        else{
            n -= 124;
            year++;
            while(n >= 365){
                if((year%4 == 0 && year%100 != 0) || year%400 == 0){
                    if(n >= 366){
                        n-=366;
                    }
                    else{
                        break;
                    }
                }
                else{
                    n-=365;
                }
                year++;
            }
            for(int i = 1; i <= 12 ; i++){
                if((year%4 == 0 && year%100 != 0) || year%400 == 0){
                    if(i != 2){
                        if(n >= days[i]){
                            n -= days[i];
                        }
                        else{
                            month = i;
                            break;
                        }
                    }
                    else{
                        if(n >= 29){
                            n -= 29;
                        }
                        else{
                            month = i;
                            break;
                        }
                    }
                }
                else{
                    if(n >= days[i]){
                        n -= days[i];
                    }
                    else{
                        month = i;
                        break;
                    }
                }
            }
            day = n+1;
        }
    }

    void print()
    {
        cout << setfill('0') << setw(2) << month << "/" << setw(2) << day << "/" << year << " " << setw(2) << hour << ":" << setw(2) << minute << ":" << setw(2) << second << endl;
    }

private:
    int second;
    int minute;
    int hour;
    int day;
    int month;
    int year;
};

int main()
{
    unsigned long long num;
    cin>>num;
    TAD test(num);
    test.print();
    return 0;
}
