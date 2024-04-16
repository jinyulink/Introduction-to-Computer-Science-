'''
Practice 2 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

while True :
    first_pass_string=input("Please enter your password: ")
    if first_pass_string=="exit":
        break
    upper_check=False
    num_check=False
    for check_string in first_pass_string:
        if ord(check_string)>=65 and ord(check_string)<=90:
            upper_check=True
        if ord(check_string)>=48 and ord(check_string)<=57:
            num_check=True
    if len(first_pass_string)<6 or len(first_pass_string)>10:
        print("Password should contain 6 to 10 characters, try again or type \"exit\" to leave.")
        continue
    if upper_check==False:
        print("Password should contain at least one upper-case alphabetical character, try again or type \"exit\" to leave.")
        continue
    if num_check==False:
        print("Password should contain at least one number, try again or type \"exit\" to leave.")
        continue
    print("Password is valid.")
    break