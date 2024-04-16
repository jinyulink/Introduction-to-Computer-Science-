'''
Practice 8
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''
def preprocess():
    with open('input.txt', 'r') as file:
        # 額外補充：map(function, iterable) 將iterable中的每個物件以function做處理並回傳sequence
        #          在這裡就是將int()作為function,將從檔案中讀出的list作為iterable
        #          由於回傳的是sequence 因此需要list()來強制轉換
        #          帥氣度破表
        data = list(map(int, file.read().split()))
    return data

data=preprocess()
for i in range(len(data)):
    for j in range(0,len(data)-1):
        if  data[j]>data[j+1]:
            data[j],data[j+1]=data[j+1],data[j]
print(data)