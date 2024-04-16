/*
Practice 12
Name: 林晉宇
Student Number: 110403518
Course 2022-CE1003-A
*/
#include<iostream>
using namespace std;
int n,m,ans=0;
int G[11][11],vis[11][11];
int dx[4]={1,0,-1,0},dy[4]={0,1,0,-1};
void dfs(int x,int y)
{
    G[x][y]=0;
    for(int i=0;i<4;i++)
    {
        int nx=x+dx[i],ny=y+dy[i];
        if(G[nx][ny]==1&&nx>=1&&nx<=10&&ny>=1&&ny<=10)    dfs(nx,ny);
    }
}
int main()
{
    cin>>n>>m;
    for(int i=1;i<=n;i++)    for(int j=1;j<=m;j++)    cin>>G[i][j];
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=m;j++)
        {
            if(G[i][j]==1)
            {
                ans++;
                dfs(i,j);
            }
        }
    }
    cout<<ans<<'\n';
    return 0;
}