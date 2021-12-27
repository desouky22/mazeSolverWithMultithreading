package test;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextField;
import static javax.swing.JOptionPane.showMessageDialog;


public class MainClass {
    public static final int N = (int) 1e3 , INF = (int) 1e9;
    public static int[][] dis = new int[N][N];
    public static int [][] Prv = new int [N][N];
    public static int [][] Grid = new int [N][N];
    public static int [][] vis = new int [N][N];
    public static int size = 0;
    public static int [] colors = new int[4];

    public static void main(String[] args) throws InterruptedException {
        RUN();
    }
    
    public static void RUN() throws InterruptedException{
        init(size);

        MyThread  runner = new MyThread(0,0,0,-1);
        Thread t0 = new Thread(runner);
        t0.start();
        t0.join();
      
        if(dis[size-1][size-1]== INF){
            showMessageDialog(null , "There is NO PATH");
            System.exit(0);
            return ;
        }else{
            path(size-1,size-1);
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
    
    public static boolean validIndex(int i , int j, int curDis){
        return i >= 0 && i < size && j < size && j >= 0 && dis[i][j] >= curDis;
    }

    public static boolean valid(int i, int j, int curDis){
        return i >= 0 && i < size && j < size && j >= 0 && dis[i][j] >= curDis && Grid[i][j] != 0;
    }

    public static void path(int i , int j){
        if(Prv[i][j] == -1) return;
        else if(Prv[i][j]==1){
            path(i-1,j);
        }else {
            path(i,j-1);
        }
        vis[i][j]=1;
    }
    
    public static boolean isInt(String s){
        try{
            int a = Integer.parseInt(s);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
