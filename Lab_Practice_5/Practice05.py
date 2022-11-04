'''
Practice 5
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
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
    for element in student_list:
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

file=open("score.txt",'r')
input_file_readline=file.read()
input_file_string_list=input_file_readline.split()
info_list_2d=split_info(input_file_string_list)
output_str=""
for element_list in info_list_2d:
    output_str+=grading_system(element_list)+'\n'
file=open("output.txt","w")
file.write(output_str)
file.close()