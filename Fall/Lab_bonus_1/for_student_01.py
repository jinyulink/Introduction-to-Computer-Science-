'''
Bonus 1
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def Output( count, total ) :
    # count為一個list，包含特別獎、特獎、頭獎、二獎、三獎、四獎、五獎、六獎和沒中獎的次數
    # total為中獎總金額
    print('特別獎：', count[0])
    print('特獎：', count[1])
    print('頭獎：', count[2])
    print('二獎：', count[3])
    print('三獎：', count[4])
    print('四獎：', count[5])
    print('五獎：', count[6])
    print('六獎：', count[7])
    print('沒中獎：', count[8])
    print(total)

invoice_file=open('Lab_bonus_1\invoice.txt','r')
invoice_list=invoice_file.read().split('\n')
num_file=open('Lab_bonus_1/num.txt','r')
num_list=num_file.read().split()
count=[0,0,0,0,0,0,0,0,0]
prize=[0,0,0,200,1000,4000,10000,40000,200000,2000000,10000000]
total=0
for invoice in invoice_list:
    check=False #有沒有中獎 
    for i in range(0,8):
        num=num_list[i][::-1]
        same_digit=0
        c=-1
        for j in num:
            if j==invoice[c]:
                same_digit+=1
                c-=1
            else:
                break
        if same_digit>=3 and i>1:
            check=True
            total+=prize[same_digit]
            count[10-same_digit]+=1
        elif same_digit==8:
            check=True
            total+=prize[same_digit+2-i]
            count[8-same_digit+i]+=1
        if check:
            break
    if check==False:
        count[8]+=1

Output(count,total)