/*
Assignment 13
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
*/
#include<iostream>
#include<vector>
#include<string>
using namespace std;
int n;
int *arr1,*arr2,*arr3;
string op;
int *mergearray(int *arr1, int *arr2, int length, int (*ptr)(int,int))
{
    int *tmp;
    tmp=new int[length];
    for(int i=0;i<length;i++)
        *(tmp+i)=ptr(*(arr1+i),*(arr2+i));
    return tmp;
}
int add(int a,int b)
{
    return a+b;
}
int sub(int a,int b)
{
    return a-b;
}
int mul(int a, int b)
{
    return a*b;
}
int main()
{
    cin>>n;
    arr1=new int[n],arr2=new int[n];
    for(int i=0;i<n;i++)    cin>>*(arr1+i);
    for(int i=0;i<n;i++)    cin>>*(arr2+i);
    cin>>op;
    if(op=="add")
    {
        int (*add_ptr)(int,int)=add;
        arr3=mergearray(arr1,arr2,n,add_ptr);
    }
    else if(op=="sub")
    {
        int (*sub_ptr)(int,int)=sub;
        arr3=mergearray(arr1,arr2,n,sub_ptr);
    }
    else if(op=="mul")
    {
        int (*mul_ptr)(int,int)=mul;
        arr3=mergearray(arr1,arr2,n,mul_ptr);
    }
    for(int i=0;i<n;i++)    cout<<*(arr3+i)<<' ';
    cout<<'\n';
    return 0;
}