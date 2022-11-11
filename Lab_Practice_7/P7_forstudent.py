'''
Practice 7
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
'''

def get_maze():
    f = open('Lab_Practice_7\input.txt', 'r')
    maze = []
    for lines in f.readlines():
        maze.append(lines.split())
    f.close()
    return maze

def dfs(x,y):
    vis[x][y]+=1
    if x==5 and y==5:
        return
    dir=[[0,1],[1,0]]
    for i in dir:
        if maze[x+i[0]][y+i[1]]=='1':
            maze[x][y]='0'
            dfs(x+i[0],y+i[1])
            maze[x][y]='1'
    
maze=get_maze()
vis=[]
for i in range(7):
    vis.append([0]*7)
dfs(1,1)
if vis[5][5]!=0:
    print("1")
else:
    print("0")