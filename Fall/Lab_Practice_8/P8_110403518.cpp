/*
Practice 8
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<bits/stdc++.h>
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(0)
#define ll long long
using namespace std;
ll a,b;
ll gcd(ll a,ll b){
    return b?gcd(b,a%b):a;
}
int main()
{
    IO;
    cin>>a>>b;
    cout<<gcd(a,b)<<'\n';
    return 0;
}