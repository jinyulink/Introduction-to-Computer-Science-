/*
Assignment 10
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
*/
#include<iostream>
#include<vector>
using namespace std;
//===========================V=global=V===========================
vector<string> g_token_list;
char g_char=0;
char special[24]={'+','-','*','/','>','<','=','%','&','|','^','\"','.',',','(',')','[',']','{','}','!',':',';'};
string special_sym[9]={"++","--","+=","<=",">=","==","!=","&&","||"};
//===========================Λ=global=Λ===========================
//===========================V=print=V============================
void print_token_sum( int sum ) {
  cout << "Total number of tokens: " << sum << endl;
} 
void print_token( string token ) {
  cout << "[" << token << "]" << endl;
}
void print_types_info( int i_num, int n_num, int s_num ) {
  cout << "Identifier: " << i_num << ", " << "Number: " << n_num << ", " << "Special Symbol: " << s_num << endl;
} 
void print_invalid_command() {
  cout << "Invalid command." << endl;
}
//===========================Λ=print=Λ============================
//===========================V=judge=V============================
bool is_identifier( char c ) {
  bool result = false;
  if(c=='_'||(c>='A'&&c<='Z')||(c>='a'&&c<='z'))  result=true;
  return result;
} 
bool is_number( char c ) {
  bool result = false;
  if(c>='0'&&c<='9')  result=true;
  return result;
} 
bool is_special_symbol( char c ) {
  bool result = false;
  for(auto i:special) if(c==i)  result=true;
  return result;
}
//===========================Λ=judge=Λ============================
//===========================V=input=V============================
void skip_white_space() {
    while(g_char==' '||g_char=='\t'||g_char=='\n')
        cin>>g_char;
}
string get_token_type(string token) {
    string type;
    if(is_identifier(token[0]))  type="identifier";
    else if(is_number(token[0])) type="number";
    else if(is_special_symbol(token[0])) type="special_symbol";
    return type;
} 
void excute_command( int cmd ) {
    if(cmd==1)  print_token_sum(g_token_list.size());
    else if(cmd==2) for(auto i:g_token_list)  print_token(i);
    else if(cmd==3)
    {
        int a=0,b=0,c=0;
        for(auto i:g_token_list)
        {
            if(get_token_type(i)=="identifier") a++;
            else if(get_token_type(i)=="number")  b++;
            else if(get_token_type(i)=="special_symbol") c++;
        }
        print_types_info(a,b,c);
    }
    else    print_invalid_command();
} 
string get_token() {
    string token;
    skip_white_space();
    token.push_back(g_char);
    char c;
    while(c=getchar())
    {
        if(is_identifier(g_char))
        {
            if(is_identifier(c)||is_number(c))  token+=c;
            else    {g_char=c;  break;}
        }
        else if(is_number(g_char))
        {
            if(is_number(c))    token+=c;
            else    {g_char=c;   break;}
        }
        else if(is_special_symbol(g_char))
        {
            if(is_special_symbol(c))
            {
                int check=1;    string tmp="";  tmp+=g_char;    tmp+=c;
                for(auto i:special_sym) 
                    if(i==tmp)  {token+=c; check=0;}   
                if(check)   {g_char=c;   break;}
            }
            else    {g_char=c;   break;}
        }
        else    {g_char=c;   break;}
    }
    return token;
} 
void get_user_input() {
    g_char=getchar();
    string token=get_token();
    while(token!="END_OF_FILE")   
    {
        g_token_list.push_back(token);
        token=get_token();
    }
} 
//===========================Λ=input=Λ============================
int main()
{
    get_user_input();
    int cmd;
    while(cin>>cmd&&cmd)    excute_command(cmd);
    return 0;
}