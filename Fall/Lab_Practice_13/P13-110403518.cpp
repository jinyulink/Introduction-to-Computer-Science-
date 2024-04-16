/*
Practice 13
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
#include<string>
#include<vector>
using namespace std;
int a,b;
int *arr1,*arr2,*tmp;
void merge_sort(int *p,int l,int r)
{
    if(l>=r)    return;
    int mid=l+r>>1;
    merge_sort(p,l,mid);
    merge_sort(p,mid+1,r);
    int k=0,i=l,j=mid+1;
    while(i<=mid&&j<=r)
    {
        if(p[i]<=p[j])  *(tmp+(k++))=*(p+(i++));
        else    *(tmp+(k++))=*(p+(j++));
    }
    while(i<=mid)   *(tmp+(k++))=*(p+(i++));
    while(j<=r) *(tmp+(k++))=*(p+(j++));
    for(int i=l,j=0;i<=r;i++,j++)   *(p+i)=*(tmp+j);
    return;
}
void merge(int *a1,int *a2)
{
    int *p=new int[a+b];
    for(int i=0;i<a+b;i++)
    {
        if(i<a) *(p+i)=*(a1+i);
        else    *(p+i)=*(a2+i%a);
    }
    tmp=new int[a+b];
    merge_sort(p,0,a+b-1);
    for(int i=0;i<a+b;i++)  cout<<*(p+i)<<' ';
    cout<<endl;
    return;
}
int main()
{
    cin>>a;
    arr1=new int[a];
    for(int i=0;i<a;i++)    cin>>*(arr1+i);
    cin>>b;
    arr2=new int[b];
    for(int i=0;i<b;i++)    cin>>*(arr2+i);
    merge(arr1,arr2);
    return 0;
}