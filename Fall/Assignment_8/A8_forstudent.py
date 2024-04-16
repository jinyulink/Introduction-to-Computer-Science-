'''
Assignment 8
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1001-A
'''
import copy 

def preprocess():
    with open('Assignment_8\input.txt', 'r') as file:
        # 額外補充：map(function, iterable) 將iterable中的每個物件以function做處理並回傳sequence
        #          在這裡就是將int()作為function,將從檔案中讀出的list作為iterable
        #          由於回傳的是sequence 因此需要list()來強制轉換
        #          帥氣度破表
        data = list(map(int, file.read().split()))
    return data


def showlist(count, listname):
    print('第', count, '次', listname)

def show_original(listname):
    print('原資料：', listname)
    
data=preprocess()
org_data=copy.deepcopy(data)
for i in range(len(data)-1):
    for j in range(0,len(data)-1):
        if  data[j]>data[j+1]:
            data[j],data[j+1]=data[j+1],data[j]
    showlist(i+1, data)
show_original(org_data)