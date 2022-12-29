/*
Practice 14
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
#include<fstream>
using namespace std;
int a,b,c,d; //四科成績
string name,output_string;
int main()
{
    ifstream score("score.txt",ios::in);
    ofstream output("output.txt",ios::out);
    while(score>>name>>a>>b>>c>>d) //12 12 8 12
    {
        bool check=true;
        if(a<12)    check=false;
        if(b<12)    check=false;
        if(c<8)    check=false;
        if(d<12)    check=false;
        if(check)   output<<"Hello "+name+", welcome to NCU CSIE!\n";
        else    output<<"Sorry, "+name+" can't enter NCU CSIE.\n";
    }
    score.close();//close file
    output.close();
    return 0;
}