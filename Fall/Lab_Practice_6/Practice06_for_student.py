'''
Practice 6
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''
import math

def print_dec(dec_num):
    print("NUM(DEC) : {}".format(dec_num))#format function will replace the "{}" with given variables, you can google it for the detail
        
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

number = input("NUM(BIN) : ")
# write your code form here...
check=True
# if input is not binary number, like "abc","7789", use print_err_msg() to print msg.
for i in number:
    if i!='0' and i!='1':
        check=False
        break
if check==False:
    print_err_msg()
else:
    bin_to_dec(number)
# do not use "int(number,2)"

# ...to here