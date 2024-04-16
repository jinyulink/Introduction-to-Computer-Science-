# include<iostream>
# include<vector>
using namespace std;

// ========== Global Variables ========== 

vector <string> g_token_list; // Global token list
char g_char=0; // Global character

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

// !!! Copy and Paste the functions that you've finished in Practice 10 here !!!

string get_token() {
  // Get a token from the input stream, and return the token in string type.
  // When you start to get a token, your g_char should be the first character of the token.

  string token;
  /*Your Code Here*/
  return token;

} 

void get_user_input() {
  // Use "get_token" to get user input until END_OF_FILE appears, and store the tokens into g_token_list.

  /*Your Code Here*/

} 

// ========== Main Function ==========

int main() {

  /*Your Code Here*/

}
