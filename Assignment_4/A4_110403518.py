'''
Assignment 4 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''
def exist_num(arr,num):
    for element in arr:
        if element==num:
            return True
    return False

def count_prime(user_input_int):
    prime_num=0
    file=open("Input.txt","r")
    lines=file.readlines()
    for line in lines:
        input_file_list=line.split()
        if user_input_int==int(input_file_list[0][7:]):
            for i in range(1,len(input_file_list)):
                if prime(int(input_file_list[i])):
                    prime_num+=1
    return prime_num

def find_factor_num(user_input_int):
    file=open("Input.txt","r")
    lines=file.readlines()
    for line in lines:
        input_file_list=line.split()
        if user_input_int==int(input_file_list[0][7:]):
            return len(input_file_list)-1

def prime(num):
    prime_bool=True
    if num==1: 
        prime_bool=False
    for i in range(2,num):
        if  num%i==0:
            prime_bool=False
            break
    return prime_bool

num_list=[]
file=open("Input.txt","r")
lines=file.readlines()
for line in lines:
    input_file_list=line.split()
    num_list.append(int(input_file_list[0][7:]))
user_input=input("Input the number to check exist or exit : ")

while(user_input!="exit"):
    if(exist_num(num_list,int(user_input))):
        print("Number_"+user_input+" exists in the document and the number of factor is "+str(find_factor_num(int(user_input)))+" and the number of prime is "+str(count_prime(int(user_input))))
    else:
        print("Number_"+user_input+' is not exist, please input a new number or input "exit" to leave program')
    print('Please input the next number or input "exit" to leave')
    user_input=input("Input the number to check exist or exit : ")