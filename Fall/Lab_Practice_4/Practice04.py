'''
Practice 4 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def find_factor(num):
    res_string=""
    for i in range(1,num+1):
        if num%i == 0:
            res_string+=str(i)+" "+find_prime(i)+"\n"
    return res_string

def find_prime(num):
    res_string=""
    prime_bool=True
    if num==1: 
        prime_bool=False
    for i in range(2,num):
        if  num%i==0:
            prime_bool=False
            break
    return "T" if prime_bool else "F"

file=open("input.txt","r")
input_file_readline=file.read()
input_file_string_list=input_file_readline.split()
output_string=""
list_pos_int=1
for i in input_file_string_list:
    output_string+="Number_"+str(list_pos_int)+": "+i+"\n"
    output_string+=find_factor(int(i))
    list_pos_int+=1
file=open("output.txt","w")
file.write(output_string)
file.close()