#include<iostream>
#include<fstream>
#define vt vector 
#define pb push_back
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(false)
using namespace std;
ifstream input("input.txt",ios::in); //This is the final exam.
ofstream output("output.txt",ios::out);//^rs}*s}*~ro*psxkv*o�kw8
int t,pwd=10;
char c;
string input_s,s;
void test()
{
    for(int i=0;i<s.length();i++)   s[i]+=pwd;
    cout<<s<<'\n';
    for(int i=0;i<s.length();i++)   s[i]-=pwd;
    cout<<s<<'\n';
}
int main()
{
    cin>>t;
    while(input.get(c)) s+=c;
    // test();
    if(t==1)
    {
        for(int i=0;i<s.length();i++)   s[i]+=pwd;
        output<<s;
    }
    else if(t==2)
    {
        for(int i=0;i<s.length();i++)   s[i]-=pwd;
        output<<s;
    }
    return 0;
}