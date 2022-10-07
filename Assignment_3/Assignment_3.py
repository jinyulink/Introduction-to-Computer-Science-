'''
Assignment 3 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''
def CreatePyramid(lever_int):
    res_string=""
    now_int=1
    for i in range(1,lever_int+1):
        res_string+=(" "*(lever_int-i))
        for j in range(1,(2*i-1)+1):
            res_string+=(isPrime(now_int))
            now_int+=1
        # res_string+=("*"*(2*i-1))
        if i!=lever_int+1:
            res_string+=('\n')
    return res_string

def isPrime(check_int):
    if check_int==1:
        return "1"
    if check_int==2:
        return "Y"
    for i in range(2,check_int):
        if check_int%i==0:
            return "N"
    return "Y"

file=open("input.txt","r")
level_int=file.read()
file=open("output.txt","w")
file.write(CreatePyramid(int(level_int)))
file.close()