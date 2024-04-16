'''
Exam 2
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def open_file(file_name):
    file=open(file_name, 'r')
    line=file.readlines()
    file.close()
    return line

def search_index(list,target):
    tmp=0
    for i in list:
        if i>=target:
            return tmp
        tmp+=1
    return tmp
    
list=open_file("test_data\E2_input.txt")
list_1=list[0].split()
list_2=list[1].split()
check=0
index=-1
user=input()
if ord(user[0])>=65:
    check=1 #從list_1找
else:
    check=2 #從list_2找
for i in range(0,len(list_1)):
    list_1[i]=ord(list_1[i])
for i in range(0,len(list_2)):
    list_2[i]=int(list_2[i])
if check==1:
    index=search_index(list_1,ord(user))
elif check==2:
    index=search_index(list_2,int(user))

print("Search list:",check)
print("Index:",index)
