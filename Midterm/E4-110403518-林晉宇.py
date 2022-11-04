'''
Exam 4
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def open_file(file_name):
    file=open(file_name, 'r')
    line=file.readlines()
    file.close()
    return line[0]

def check_number(num):
    for i in num:
        if ord(i)<=48 or ord(i)>57:
            return False
    if len(num)==4:
        return True
    else:
        return False
    
def cmp_number(ans_num,guess_num):
    a=0
    b=0
    check=[0,0,0,0,0,0,0,0,0,0]
    for i in range(4):
        check[int(ans_num[i])]+=1
        if guess_num[i]==ans_num[i]:
            a+=1
    for i in range(4):
        if check[int(guess_num[i])]>0:
            b+=1
            check[int(guess_num[i])]-=1
    ret=[a,b-a]
    return ret
    
str=open_file("test_data\E4_input.txt")
check=True
while check:
    user=input()
    if check_number(user)==False:
        print("input error")
    elif check_number(str)==False:
        print("answer file error")
    else:
        res=cmp_number(str,user)
        if res[0]==4:
            check=False
        print(res[0],'A',res[1],'B')