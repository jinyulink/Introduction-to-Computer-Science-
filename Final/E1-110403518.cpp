#include<iostream>
#include<vector>
#include<array>
#include<set>
#include<map>
#define vt vector 
#define pb push_back
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(false)
using namespace std;
int n,t;
void ducci(int u,int a[])
{
    for(int i=1;i<=u;i++)
    {
        int b[n];
        for(int j=0;j<n;j++)
        {
            b[j]=a[j]-a[(j+1)%n];
            if(b[j]<0)  b[j]*=-1;
        }
        for(int j=0;j<n;j++)    a[j]=b[j];
        // for(int j=0;j<n;j++)    cout<<a[j]<<' ';//
        // cout<<'\n';//
    }
    for(int j=0;j<n;j++)
    {
        cout<<a[j];
        if(j!=n-1)  cout<<' ';
    }
    cout<<'\n';
}
void ducci_check(int a[])
{
    map<vt<int>,int> mp;
    bool check=1;
    while(check)
    {
        check=0;
        int b[n];
        for(int j=0;j<n;j++)
        {
            b[j]=a[j]-a[(j+1)%n];
            if(b[j]<0)  b[j]*=-1;
        }
        for(int j=0;j<n;j++)    a[j]=b[j];
        for(int j=0;j<n;j++)    if(a[j])    check=1;
        // for(int j=0;j<n;j++)    cout<<a[j]<<' ';//
        // cout<<'\n';//
        vt<int> tmp;
        for(int j=0;j<n;j++)    tmp.pb(a[j]);
        if(mp[tmp])
        {
            cout<<"LOOP\n";
            break;
        }
        mp[tmp]++;
    }
    if(!check)  cout<<"ZERO\n";
}
int main()
{
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++)    cin>>a[i];
    cin>>t;
    if(t==1)    ducci(1,a);
    else if(t==2)   ducci(3,a);
    else if(t==3)   ducci_check(a);
    return 0;
}