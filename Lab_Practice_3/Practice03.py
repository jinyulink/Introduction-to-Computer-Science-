'''
Practice 3 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def CreatePyramid(lever_int):
    res_string=""
    for i in range(1,lever_int+1):
        res+=(" "*(lever_int-i))
        res+=("*"*(2*i-1))
        if i!=lever_int+1:
            res+=('\n')
    return res

file=open("input.txt","r")
level_int=file.read()
file=open("output.txt","w")
file.write(CreatePyramid(int(level_int)))
file.close()