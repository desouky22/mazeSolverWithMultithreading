package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class Action implements ActionListener{
    public void actionPerformed( ActionEvent e){
        Object source = e.getSource();
        for(int x = 0; x<MainClass.size; x++){
            for(int y = 0; y<MainClass.size; y++){
                if(source == AppGui.gridArray[x][y]){
                    if(AppGui.gridArray[x][y].getText() == "1")
                        AppGui.gridArray[x][y].setText("0");
                    else 
                        AppGui.gridArray[x][y].setText("1");
                }
            }
        }
    }
}
