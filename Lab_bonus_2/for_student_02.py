'''
Bonus 2
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def bin_to_dec(num):
    ret=0
    neg=False
    if num[0]=='1':
        neg=True
        num=num.replace('1','2')
        num=num.replace('0','1')
        num=num.replace('2','0')
    tt=0
    for i in num:
        ret+=int(i)*2**(len(num)-1-tt)
        tt+=1
    if neg:
        ret+=1
    return str(ret)

def reverse(decimal):
    ret=''
    if len(decimal)==1:
        return decimal
    decimal=decimal[::-1]
    check=False
    for i in decimal:
        if i!='0':
            check=True
            ret+=i
        elif check and i=='0':
            ret+=i
    return ret

def bin_to_hex(num):
    ret=''
    neg=False
    if num[0]=='1':
        neg=True
        num=num.replace('1','2')
        num=num.replace('0','1')
        num=num.replace('2','0')
    tt=len(num)%4
    num='0'*(4-tt)+num
    for i in range(int(len(num)/4)):
        tt=0
        tmp=0
        for j in range(0,4):
            tmp+=(int(num[j+i*4]))*2**(3-tt)
            tt+=1
        # print(str(tmp)+" sdsdsd")
        if i == int(len(num)/4)-1 and neg:
            tmp+=1
        if tmp>=10:
            ret+=chr(tmp-10+ord('a'))
            # print(chr(tmp-10+ord('a')))
        else:
            ret+=str(tmp)
    tmpret=''
    if ret=='0':
        tmpret+='0'
    check=False
    for i in ret:
        if i!='0':
            check=True
            tmpret+=i
        elif check and i=='0':
            tmpret+=i
    ret=tmpret
    return ret
        
def Output( decimal, decimal_reverse ,heximal ) :
  print("Decimal:", decimal)
  print("Decimal reverse:", decimal_reverse)
  print("Heximal:", heximal)
  
while 1:
    check=False
    num = input("Please input the binary : ")
    for i in num:
        if i!='0' and i!='1':
            check=True
            print("Input number is not binary")
            break
    if check:
        continue
    if num=="-1":
        break
    decimal=bin_to_dec(num)
    # print(decimal)
    decimal_reverse=reverse(decimal)
    # print(decimal_reverse)
    heximal=bin_to_hex(num)
    Output(decimal,decimal_reverse,heximal )