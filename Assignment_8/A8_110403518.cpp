/*
Assignment 8
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
*/
#include<bits/stdc++.h>
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(0)
#define ll long long
using namespace std;
ll a,b;
ll gcd(ll a,ll b){
    return b?gcd(b,a%b):a; //if b==0 return a
}
ll lcm(ll a,ll b){
    return a/gcd(a,b)*b;
}
int main()
{
    IO;
    cin>>a>>b;
    // if(a>b) swap(a,b);
    cout<<lcm(a,b)<<'\n';
    return 0;
}