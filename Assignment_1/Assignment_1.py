'''
Assignment 1
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''
chinese_float = float(input("Please enter your Chinese score: "))
english_float = float(input("Please enter your English score: "))
math_float = float(input("Please enter your English score: "))
science_float = float(input("Please enter your Science score: "))
avg_float = (chinese_float+english_float+math_float+science_float)/4
print("Your average score is:",avg_float)
pass_subject_int = 0
if chinese_float > 58.74:
    pass_subject_int += 1  
if english_float > 68.30:
    pass_subject_int += 1
if math_float > 38.93:
    pass_subject_int += 1
if science_float > 88.56:
    pass_subject_int += 1
if  pass_subject_int == 4:
    print("Welcome to NCU CSIE!")
else:
    print("Sorry, you can't enter NCU CSIE.")
