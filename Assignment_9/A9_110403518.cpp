#include<iostream>
using namespace std;
int y,m,d;
int day;
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
int which_date(int year, int month, int day)
{
    if(month==1)    month=13,year--;
    if(month==2)    month=14,year--;
    int y=year%100;
    int c=year/100;
    int res=(y+y/4+c/4-2*c+(26*(month+1))/10)+day-1;
    if(res<0)   res=res%7+7;
    res%=7;
    return res;
}
void display_calendar(int year, int month)
{
    int a = 1;
    for (a=0;a<7;a++)   cout <<"    "<<a;
    cout << endl << "=====================================" << endl;
    int day=which_date(year,month,1);
    int daycnt=nmonth(month,year);
    for(int i=0;i<day%7;i++)    cout<<"     ";
    int tmp;
    for(int i=1,j=day+1;i<=daycnt;i++,j++)
      {
        if(i>=10)
        {
            if(i==d)    cout<<"  *";
            else    cout<<"   ";
        }
        else
        {
            if(i==d)    cout<<"   *";
            else    cout<<"    ";
        }
        cout<<i;
        if(j%7==0) cout<<endl;
        tmp=j;
      }
      if(tmp%7) cout<<endl;
    cout << "=====================================" << endl;
}
int main()
{
    cin>>y>>m>>d;
    day=which_date(y,m,d);
    switch(day){
        case 0:
            cout<<"Sunday"<<endl;
            break;
        case 1:
            cout<<"Monday"<<endl;
            break;
        case 2:
            cout<<"Tuesday"<<endl;
            break;
        case 3:
            cout<<"Wednesday"<<endl;
            break;
        case 4:
            cout<<"Thursday"<<endl;
            break;
        case 5:
            cout<<"Friday"<<endl;
            break;
        case 6:
            cout<<"Saturday"<<endl;
            break;
    }
    cout<<'\n';
    display_calendar(y,m);
    return 0;
}