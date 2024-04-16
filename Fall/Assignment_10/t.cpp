void skip_white_space() {
    while(g_char==' '||g_char=='\t'||g_char=='\n')
        cin>>g_char;
}

string get_token()
{
    string token;
    skip_white_space();
    token.push_back(g_char);
    char c;
    while(cin>>c)
    {
        if(is_identifier(g_char))
        {
            if(is_identifier(c)||is_number(c))  token+=c;
            else
            {
                g_char=c;   break;
            }
        }
        else if(is_number(g_char))
        {
            if(is_number(c))    token+=c;
            else
            {
                g_char=c;   break;
            }
        }
        else if(is_special_symbol(g_char))
        {
            
        }
    }
    return token;
}