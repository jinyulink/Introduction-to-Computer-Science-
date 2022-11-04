'''
Exam 3
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def open_file(file_name):
    file=open(file_name, 'r')
    line=file.readlines()
    file.close()
    return line

def bool_finish(list):
    time=int(list[4])
    span=(int(list[2])-int(list[0]))*60-(int(list[1])-int(list[3]))
    if time<=span:
        return True
    else:
        return False
    
list=open_file("test_data\E3_input5.txt")
for i in range(1,len(list)):
    check=bool_finish(list[i].split())
    if  check==True:
        print("Yes")
    elif check==False:
        print("No")
