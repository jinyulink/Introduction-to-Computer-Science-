#include<iostream>
using namespace std;
int y,m,d;
int nyear(int year)
{
    if(year%400==0||(year%4==0&&year%100!=0))   return 366;
    else    return 365;
}
int nmonth(int m,int y)
{
    if(m==1||m==3||m==5||m==7||m==8||m==10||m==12)  return 31;
    else if(nyear(y)==366&&m==2) return 29;
    else if(nyear(y)==365&&m==2) return 28;
    else return 30;
}
int getDays(int year, int month)
{
    int sum=0;
    if(year>1900)   for(int i=1990;i<year;i++)  sum+=nyear(i);
    if(month>1) for(int i=1;i<month;i++)    sum+=nmonth(i,year);
    return sum;
}
void display_calendar(int year, int month)
{
    int a = 1;
    for (a=0;a<7;a++)
        cout <<"    "<<a;
    cout << endl << "=====================================" << endl;
    int day=getDays(year,month)%7;
    int daycnt=nmonth(month,year);
    for(int i=0;i<day%7;i++)    cout<<"    ";
    for(int i=1,j=day+1;i<=daycnt;i++,j++)
      {
         cout<<"    "<<i;
         if(j%6==0) cout<<endl;
      }
    cout<<endl;
    cout << endl << "=====================================" << endl;
}
int main()
{
    cin>>y>>m>>d;
    display_calendar(y,m);
    return 0;
}