'''
Practice 1 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

Chinese_int = int(input("Please enter your Chinese score: "))
English_int = int(input("Please enter your English score: "))
Math_int = int(input("Please enter your Math score: "))
Science_int = int(input("Please enter your Science score: "))
pass_subject_int = 0
if Chinese_int >=12 :
    pass_subject_int += 1
if English_int >=12 :
    pass_subject_int += 1
if Math_int >=8 :
    pass_subject_int += 1
if Science_int >=12 :
    pass_subject_int += 1
if pass_subject_int ==4 :
    print("Welcome to NCU CSIE!")
else :
    print("Sorry, you can't enter NCU CSIE.")