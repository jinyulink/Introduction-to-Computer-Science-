'''
Assignment 2 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''

while True :
    first_pass_string=input("Please enter your password: ")
    if first_pass_string=="exit":
        break
    second_pass_string=input("Please enter your password again: ")
    upper_check=False
    lower_check=False 
    num_check=False
    special_check=False
    special_string="~!@#$%^&*()_+|`-=\{}[]:\";'<>?,./ "
    symmetric_check=False
    for check_string in first_pass_string:
        if ord(check_string)>=65 and ord(check_string)<=90:
            upper_check=True
        if ord(check_string)>=97 and ord(check_string)<=122:
            lower_check=True
        if ord(check_string)>=48 and ord(check_string)<=57:
            num_check=True
        if special_check==False:
            for special_check_string in special_string:
                if check_string==special_check_string:
                    special_check=True
                    break
    if first_pass_string==first_pass_string[::-1]:
        symmetric_check=True
    if first_pass_string!=second_pass_string:
        print("Password settings are not consistent, try again or type \"exit\" to leave.")
        continue
    if len(first_pass_string)<6 or len(first_pass_string)>10:
        print("Password should contain 6 to 10 characters, try again or type \"exit\" to leave.")
        continue
    if upper_check==False:
        print("Password should contain at least one upper-case alphabetical character, try again or type \"exit\" to leave.")
        continue
    if lower_check==False:
        print("Password should contain at least one lower-case alphabetical character, try again or type \"exit\" to leave.")
        continue
    if num_check==False:
        print("Password should contain at least one number, try again or type \"exit\" to leave.")
        continue
    if special_check==False:
        print("Password should contain at least one special character, try again or type \"exit\" to leave.")
        continue
    if symmetric_check==True:
        print("Symmetric password is not allowed, try again or type \"exit\" to leave.")
        continue
    print("Password is valid.")
    break