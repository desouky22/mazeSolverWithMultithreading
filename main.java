package com.company;
import java.util.Scanner;

public class Main {
    public static final int N = (int) 1e3 , INF = (int) 1e9;
    public static int[][] dis = new int[N][N];
    public static int [][] Prv = new int [N][N];
    public static int [][] Grid = new int [N][N];
    public static int [][] vis = new int [N][N];
    public static int size = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner (System.in);
        size = input.nextInt();
        init(size);

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                Grid[i][j]=input.nextInt();
            }
        }

        MyThread  runner = new MyThread(0,0,0,-1);
        Thread t0 = new Thread(runner);
        t0.start();
        t0.join();
        if(dis[size-1][size-1]== INF){
            System.out.println("No path -1");
            return ;
        }
        path(size-1,size-1);
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++)System.out.print(vis[i][j] + " ");
            System.out.println();
        }
    }

    public static void init(int sz){
        for(int i=0;i<sz;i++){
            for(int j=0;j<sz;j++){
                dis[i][j]= INF;
                Prv[i][j]= INF;
                vis[i][j]=0;
            }
        }
        vis[0][0]=1;
    }

    public static boolean valid(int i, int j, int curDis){
        return i >= 0 && i < size && j < size && j >= 0 && dis[i][j] >= curDis && Grid[i][j] != 0;
    }

    public static void path(int i , int j){
        if(Prv[i][j]==-1)return;
        else if(Prv[i][j]==1){
            path(i-1,j);
        }else {
            path(i,j-1);
        }
        vis[i][j]=1;
    }
}
