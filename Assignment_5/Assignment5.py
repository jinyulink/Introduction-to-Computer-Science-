'''
Assignment 5 
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''

def split_info(input_list):
    return_list=[]
    info_1d=[]
    for element in input_list:
        info_1d.append(element)
        if len(info_1d)==5:
            return_list.append(info_1d)
            info_1d=[]
    return return_list

def grading_system(student_list):
    str=""
    name=""
    check_int=1
    check=True
    for element in element_list:
        if check_int==1:
            name=element
            check_int+=1
        elif check_int==4: 
            check_int+=1
            if int(element)<8:  
                check=False
        else:
            check_int+=1
            if int(element)<12:  
                check=False
    if check:
        str+="Hello "+name+", welcome to NCU CSIE!"
    else:
        str+="Sorry, "+name+" can't enter NCU CSIE."
    return str

def find_grade(s_list, name, subject):
    return_str=''
    for element_list in s_list:
        if element_list[0]==name: 
            if subject=='chinese':
                return_str=element_list[1]
            elif subject=='english':
                return_str=element_list[2]
            elif subject=='math':
                return_str=element_list[3]
            elif subject=='science':
                return_str=element_list[4]
    return return_str+'\n'

file=open("score.txt",'r')
input_file_readline=file.read()
input_file_string_list=input_file_readline.split()
info_list_2d=split_info(input_file_string_list)
output_str=""
for element_list in info_list_2d:
    output_str+=grading_system(element_list)+'\n'
file.close()
file=open("cmd.txt",'r')
input_file_readline2=file.read()
input_file_string_list2=input_file_readline2.split()
# print(input_file_string_list2)
for i in range(int(len(input_file_string_list2)/2)):
    output_str+=find_grade(info_list_2d,input_file_string_list2[i*2],input_file_string_list2[i*2+1])
    print(input_file_string_list2[i*2],input_file_string_list2[i*2+1])
file=open("output.txt","w")
file.write(output_str)
file.close()