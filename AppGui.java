import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppGui extends javax.swing.JFrame {
    public static JButton[][] gridArray = new JButton[1000][1000];
    public static JTextField [][] answerGrid = new JTextField[1000][1000];

    /**
     * Creates new form AppGui
     */
    public AppGui() {
        
        initComponents();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstText = new javax.swing.JTextField();
        Ok = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter the width of the grid");

        firstText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstTextActionPerformed(evt);
            }
        });

        Ok.setText("Generate the Grid");
        Ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OkActionPerformed(evt);
            }
        });

        jButton1.setText("Solve the Maze");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(firstText, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ok, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );

        pack();
    }// </editor-fold>                        

    private void firstTextActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void OkActionPerformed(java.awt.event.ActionEvent evt) {                                   
        if(MainClass.isInt(firstText.getText())){
            MainClass.size = Integer.parseInt(firstText.getText());

            JFrame frame = new JFrame();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 500);
            
            Action a = new Action() {};
            
            for(int x = 0; x<MainClass.size; x++){
                for (int y = 0; y<MainClass.size; y++){
                    gridArray[x][y] = new JButton("0");
                    gridArray[x][y].addActionListener(a); 
                }
            }
            
            frame.setLayout(new GridLayout(MainClass.size , MainClass.size));
            for(int x = 0; x<MainClass.size; x++ ){
                for(int y = 0; y<MainClass.size; y++){
                    frame.add(gridArray[x][y]);
                }
            }
            gridArray[0][0].setText("1");
            gridArray[MainClass.size-1][MainClass.size-1].setText("1");
        }
        else  System.exit(0);
    }                                  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        for (int x = 0; x<MainClass.size; x++){
            for(int y = 0; y<MainClass.size; y++){
                if(gridArray[x][y].getText() == "0")
                    MainClass.Grid[x][y] = 0;
                else 
                    MainClass.Grid[x][y] = 1;
            }
        }
        
        try {
            MainClass.RUN();
            JFrame answerFrame = new JFrame();
            answerFrame.setVisible(true);
            answerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            answerFrame.setSize(500, 500);
            
            
            for(int x = 0; x<MainClass.size; x++){
                for(int y = 0; y<MainClass.size; y++){
                    answerGrid[x][y] = new JTextField();
                    if(MainClass.vis[x][y] == 1) answerGrid[x][y].setBackground(Color.red);
                    else if (MainClass.Grid[x][y] == 0) answerGrid[x][y].setBackground(Color.gray);
                    else answerGrid[x][y].setBackground(Color.white);
                }
            }
            answerFrame.setLayout(new GridLayout(MainClass.size , MainClass.size));
            
            for(int x = 0; x<MainClass.size; x++ ){
                for(int y = 0; y<MainClass.size; y++){
                    answerFrame.add(answerGrid[x][y]);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(AppGui.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }                                        

    
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Ok;
    private javax.swing.JTextField firstText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
