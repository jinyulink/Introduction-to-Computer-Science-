/*
Practice 10
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
# include<iostream>
# include<vector>
using namespace std;

// ========== Global Variables ========== 

vector <string> g_token_list; // Global token list
char special[24]={'+','-','*','/','>','<','=','%','&','|','^','\"','.',',','(',')','[',']','{','}','!',':',';'};

// ========== Print Function ==========

void print_types_info( int i_num, int n_num, int s_num ) {
  cout << "Identifier: " << i_num << ", " << "Number: " << n_num << ", " << "Special Symbol: " << s_num << endl;
}

void print_invalid_command() {
  cout << "Invalid command." << endl;
}

void print_token( string token ) {
  cout << "[" << token << "]" << endl;
} 

void print_token_sum( int sum ) {
  cout << "Total number of tokens: " << sum << endl;
} 

// ========== Other Functions ==========

void skip_white_space() {
  // skip white space such as ' ', '\t', '\n', and make g_char the first character of the next token

  /*Your Code Here*/

}

bool is_identifier( char c ) {
  // given a character, return true if it is a part of a identifier
  bool result = false;
  if(c=='_'||(c>='A'&&c<='z'))  result=true;
  /*Your Code Here*/
  return result;

} 

bool is_number( char c ) {
  // given a character, return true if it is a number
  bool result = false;
  if(c>='0'&&c<='9')  result=true;
  /*Your Code Here*/
  return result;

} 

bool is_special_symbol( char c ) {
  // given a character, return true if it is a special symbol or not
  bool result = false;
  for(auto i:special) if(c==i)  result=true;
  /*Your Code Here*/
  return result;

}

void get_user_input() {
  // Get user input until END_OF_FILE appears, and store the tokens into g_token_list.
  string s;
  while(cin>>s)
  {
    if(s=="END_OF_FILE")  break;
    g_token_list.push_back(s);
  }
  /*Your Code Here*/
} 

string get_token_type(string token) {
  // Given a token, return the type of the token.(Identifier, Number, or Special Symbol?)
  string type;
  if(is_identifier(token[0]))  type="identifier";
  else if(is_number(token[0])) type="number";
  else if(is_special_symbol(token[0])) type="special_symbol";
  /*Your Code Here*/
  return type;

} 

void excute_command(int cmd) {
  int a=0,b=0,c=0;
  switch(cmd)
  {
    case 1:
      print_token_sum(g_token_list.size());
      break;
    case 2:
      for(auto i:g_token_list)  print_token(i);
      break;
    case 3:
      for(auto i:g_token_list)
      {
        if(get_token_type(i)=="identifier") a++;
        else if(get_token_type(i)=="number")  b++;
        else c++;
      }
      print_types_info(a,b,c);
      break;
    default:
      print_invalid_command();
      break;
  }
} 

// ========== Main Function ==========

int main() {
  // Get User Input form the input stream, and execute the command until command == 0.
  get_user_input();
  int cmd;
  while(cin>>cmd&&cmd)  excute_command(cmd);
  /*Your Code Here*/
  return 0;
}
