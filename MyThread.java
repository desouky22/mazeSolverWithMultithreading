package com.company;

import java.lang.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyThread implements Runnable {
    int idxI, idxJ, curDis, fromWhere;
    public MyThread(int i,int j,int curDis1,int par){
        this.idxI =i;
        this.idxJ =j;
        this.curDis =curDis1;
        this.fromWhere =par;
        Main.dis[i][j]= curDis;
        Main.Prv[i][j]= fromWhere;
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
        int  goi , goj , godis;
        goi = i + 1;
        goj = j ;
        godis = curDis + 1;
        if(Main.valid(goi,goj,godis)){
            MyThread runnner = new MyThread(goi,goj,godis,1);
            Thread runfromdown = new Thread(runnner);
            runfromdown.start();
            runfromdown.join();
        }
        goi = i ;
        goj = j + 1;
        if(Main.valid(goi,goj,godis)){
            MyThread runnner = new MyThread(goi,goj,godis,2);
            Thread runfromright = new Thread(runnner);
            runfromright.start();
            runfromright.join();
        }
    }

}
