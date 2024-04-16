'''
Practice 3 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def CreatePyramid(lever_int):
    res_string=""
    for i in range(1,lever_int+1):
        res_string+=(" "*(lever_int-i))
        res_string+=("*"*(2*i-1))
        if i!=lever_int:
            res_string+=('\n')
    return res_string

file=open("Lab_Practice_3/input.txt","r")
level_int=file.read()
file=open("Lab_Practice_3/output.txt","w")
file.write(CreatePyramid(int(level_int)))
file.close()