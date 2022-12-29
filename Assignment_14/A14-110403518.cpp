/*
Assignment 14
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
*/
#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<map>
#define vt vector
#define pb push_back
using namespace std;
int a,b,c,d; //四科成績
string name,subject,output_string;
map<string,vt<int>> mp;
map<string,int> mp2={{"chinese",0}, {"english",1}, {"math",2}, {"science",3}};
int main()
{
    ifstream score("score.txt",ios::in);
    ifstream cmd("cmd.txt",ios::in);
    ofstream output("output.txt",ios::out);
    while(score>>name>>a>>b>>c>>d) //12 12 8 12
    {
        mp[name].pb(a); mp[name].pb(b); mp[name].pb(c); mp[name].pb(d);
        bool check=true;
        if(a<12)    check=false;
        if(b<12)    check=false;
        if(c<8)    check=false;
        if(d<12)    check=false;
        if(check)   output<<"Hello "+name+", welcome to NCU CSIE!\n";
        else    output<<"Sorry, "+name+" can't enter NCU CSIE.\n";
    }
    while(cmd>>name>>subject)
    {
        output<<to_string(mp[name][mp2[subject]])+'\n';
    }
    score.close();//close file
    cmd.close();
    output.close();
    return 0;
}