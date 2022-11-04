'''
Assignment 6
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''
import math

def print_dec(dec_num):
    print("NUM(DEC) : {}".format(dec_num))
    
def print_oct(oct_num):
    print("NUM(OCT) : {}".format(oct_num)) #format function will replace the "{}" with given variables, you can google it for the detail
    
def print_err_msg():
    err_msg = "Not Binary Number!"
    print(err_msg)
    
def bin_to_dec(num):
    n=len(num)
    ans=0
    for i in num:
        ans+=int(i)*int(math.pow(2,n-1))
        n-=1
    print_dec(ans)
    
def bin_to_oct(num):
    n=len(num)
    ans=''
    if n%3==1:
        num='00'+num
    elif n%3==2:
        num='0'+num
    for i in range(0,len(num),3):
        ans+=str(int(num[i])*4+int(num[i+1])*2+int(num[i+2]))
    ret=''
    check=False
    for i in ans:
        if i!='0' or check:
            ret+=i
            check=True
    print_oct(ret)
    
while 1:
    number = input("NUM(BIN) : ")
    # write your code form here...
    if number=='-1':
        break
    check=True
    for i in number:
        if i!='0' and i!='1':
            check=False
            break
    if check==False:
        print_err_msg()
    else:
        bin_to_dec(number)
        bin_to_oct(number)
    # if number equal to "-1" then break the while loop.
    
    # if input is not binary number, like "abc","7789", use print_err_msg() to print msg.
    
    # do not use "int(number,2)"
    
    # ...to here