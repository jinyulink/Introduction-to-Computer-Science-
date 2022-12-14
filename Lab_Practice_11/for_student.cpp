/*
Practice 11
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
#include<vector>
#include<map>
using namespace std;

map<int,int> get_input(map<int,int> doll_map){
    int n;  cin>>n;
    while(n--)
    {
        int x; cin>>x;
        doll_map[x]++;
    }
    return doll_map;
}

void calculate_doll(map<int,int>& doll_map){
    int res=0;
    for(auto i:doll_map)
        if(i.second>res) res=i.second;
    cout<<res<<'\n';
}

int main(){
    map<int,int> doll_map;
    doll_map=get_input(doll_map);
    calculate_doll(doll_map);
    return 0;
}
