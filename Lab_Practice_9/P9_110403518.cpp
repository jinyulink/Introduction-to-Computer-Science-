/*
Practice 9
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
using namespace std;
int year,month,day;
int which_date(int year, int month, int day)
{
    if(month==1)    month=13,year--;
    if(month==2)    month=14,year--;
    int y=year%100;
    int c=year/100;
    int res=(y+y/4+c/4-2*c+(26*(month+1))/10)+day-1;
    if(res<0)   res=res%7+7;
    return res%7;
}
int main()
{
    cin>>year>>month>>day;
    int ans=which_date(year,month,day);
    switch(ans){
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
    return 0;
}