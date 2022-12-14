#include<iostream>
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(false)
using namespace std;
string s,s2;
int n,res,tmp;
char spec1[4]={'W','Z','I','O'};
int spec2[4]={32,33,34,35};
int  num[11]={1,9,8,7,6,5,4,3,2,1,1};
void func_1()
{
    s2="";
    for(int i=0;i<s.length();i++)
    {
        if(i==0)
        {
            tmp=s[i]-'A'+10;
            for(auto j:spec1)   if(s[i]>j)  tmp--;
            for(int j=0;j<4;j++)   if(s[i]==spec1[j]) tmp=spec2[j];
            s2+=(tmp/10+'0');
            s2+=(tmp%10+'0');
        }
        else    s2+=s[i];
    }
    cout<<s2<<'\n';
}
void func_2()
{
    res=0,tmp=0;
    for(auto i:s2)
        res+=(i-'0')*num[tmp++];
    cout<<res<<'\n';
}
void func_3(){
    cout<<(((res%10)==0)?"1":"0")<<'\n';
}
int main()
{   
    IO;
    cin>>s; //身分證字號
    while(cin>>n)
    {
        if(!n)  break;
        else if(n==1)   func_1();
        else if(n==2)   func_2();
        else if(n==3)   func_3();
    }
    return 0;
}