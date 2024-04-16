'''
Exam 1
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def open_file(file_name):
    file=open(file_name, 'r')
    line=file.readlines()
    ret_list=line[0].split()
    file.close()
    return ret_list

list=open_file("test_data\E1_input3.txt")
new_list=[int(list[0])]
for i in range(1,len(list)):
    new_list.append(new_list[i-1]+int(list[i]))
print("new_list = ",new_list)