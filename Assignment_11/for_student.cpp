/*
Assignment 11
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
*/
# include<iostream>
# include<map>
# include<vector>
using namespace std;
int n,sz;
string animal;
map<string,map<int,int>> get_input(map<string,map<int,int>>& doll_map){
    cin>>n;
    while(n--)
    {
        cin>>sz>>animal;
        doll_map[animal][sz]++;
    }    
}

void calculate_doll(map<string,map<int,int>>& doll_map){
    int ans=0;
    for(auto it=doll_map.begin();it!=doll_map.end();it++)
    {
        int tmp=1;
        for(auto i:it->second)
            if(i.second>tmp)    tmp=i.second;
        ans+=tmp;
    }
    cout<<ans<<'\n';
}

int main(){
    map<string,map<int,int>> doll_map;
    get_input(doll_map);
    calculate_doll(doll_map);
    return 0;
}
