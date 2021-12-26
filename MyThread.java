package test;
import java.awt.Color;
import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import test.MainClass;

public class MyThread implements Runnable {
    int idxI, idxJ, curDis, fromWhere;
    public  MyThread(int i,int j,int curDis1,int par){
        this.idxI =i;
        this.idxJ =j;
        this.curDis =curDis1;
        this.fromWhere =par;
        MainClass.dis[i][j]= curDis;
        MainClass.Prv[i][j]= fromWhere;
    }

    @Override
    public void run() {
        try {
            dfs(idxI, idxJ, curDis);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void dfs(int i,int j,int curDis ) throws InterruptedException{
        int  goi  = i + 1 , goj  = j ,godis = curDis + 1;

        if(MainClass.valid(goi,goj,godis)){
            MyThread runnner = new MyThread(goi,goj,godis,1);
            Thread runfromdown = new Thread(runnner);
            runfromdown.start();
            runfromdown.join();
        }
        
        goi = i ;
        goj = j + 1;
        if(MainClass.valid(goi,goj,godis)){
            MyThread runnner = new MyThread(goi,goj,godis,2);
            Thread runfromright = new Thread(runnner);
            runfromright.start();
            runfromright.join();
        }
    }
}
