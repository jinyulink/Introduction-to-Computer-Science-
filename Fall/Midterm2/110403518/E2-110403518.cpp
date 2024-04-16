#include<iostream>
#include<map>
#include<set>
#include<vector>
#define vt vector
#define pb push_back
using namespace std;
int n,s;
string c;
char st;
char d[4]={'N','E','S','W'},dd[4]={'S','W','N','E'},ar[4]={'C','D','S','H'},bg[5]={'T','J','Q','K','A'};
vt<string> tmp;
set<string> tmp2;
map<string,char> card;
map<char,vt<string>> player;
map<char,map<char,set<string>>> arrange_player;
void func_1(){
    cout<<card["C3"]<<'\n';
}
void func_2()
{
    for(int i=0;i<4;i++)
    {
        cout<<dd[i]<<':';
        for(auto j:player[dd[i]])   cout<<' '<<j;
        cout<<'\n';
    }
}
void func_3()
{
    for(int i=0;i<4;i++)
    {
        cout<<dd[i]<<':';
        for(int j=0;j<4;j++)
        {
            map<char,int> rec;
            for(auto k:arrange_player[dd[i]][ar[j]])   
            { 
                if(k[1]>='A')   rec[k[1]]++;
                else    cout<<' '<<k;
            }
            for(int k=0;k<5;k++)
                if(rec[bg[k]])  cout<<' '<<ar[j]<<bg[k];
        }
        cout<<'\n';
    }
}
int main()
{
    cin>>st;
    for(int i=0;i<4;i++)
    {
        if(d[i]==st)   s=i; 
        player[d[i]]=tmp;
        for(int j=0;j<4;j++)
            arrange_player[d[i]][ar[j]]=tmp2;
    }
    for(int i=0;i<52;i++)
    {
        cin>>c;
        card[c]=d[(++s)%4];
        player[card[c]].pb(c);
        arrange_player[card[c]][c[0]].insert(c);
    }
    cout<<"Enter Number : ";
    cin>>n;
    if(n==1)    func_1();
    else if(n==2)   func_2();
    else if(n==3)   func_3();
    return 0;
}