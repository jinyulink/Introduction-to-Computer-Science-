/*
Practice 15
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
#include<vector>
#include<map>
#include<fstream>
#include<set>
#define IO cin.tie(0);cout.tie(0);ios_base::sync_with_stdio(false)
#define vt vector
#define pb push_back
#define F first
#define S second
using namespace std;
int ask;
char start,c3_pl,pll[4]={'N','E','S','W'},p[4]={'C','D','S','H'},pp[5]={'T','J','Q','K','A'},ppp[5]={'B','C','D','E','F'};
map<char,int> pl={{'N',0},{'E',1},{'S',2},{'W',3}};
map<char,char> mp1={{'T','B'},{'J','C'},{'Q','D'},{'K','E'},{'A','F'}},mp2={{'B','T'},{'C','J'},{'D','Q'},{'E','K'},{'F','A'}};
ifstream input("input.txt",ios::in);
ofstream output("output.txt",ios::out);
void show_card(string *p_card){
    for(int i=0;i<4;i++)
    {
        int cur=(i+2)%4;
        output<<pll[cur]<<':';
        for(int j=0,x=cur*13;j<13;j++,x++)   output<<' '<<*(p_card+x);
        output<<'\n';
    }
}
int main()
{
    IO;
    string card[4][13]; //儲存每位玩家的牌
    input>>start;
    for(int i=0;i<52;i++)
    {
        string cur_card; input>>cur_card;
        int cur_pl=(pl[start]+i+1)%4;
        card[cur_pl][i/4]=cur_card;
        if(cur_card=="C3")  c3_pl=pll[cur_pl];
    }
    show_card(&card[0][0]);
    input.close();
    output.close();
    return 0;
}