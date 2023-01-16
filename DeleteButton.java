/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tryhis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.DirectoryNotEmptyException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Grapevine Homecare
 */
public class DeleteButton implements ActionListener{
    JFrame deleteFrame = new JFrame("DELETE");
    JPanel deletePanel = new JPanel();
    JLabel lblFilename =  new JLabel("Patient's Lastname:");
    JTextField fldFilename = new JTextField(15);
    JButton btnDelete = new JButton("Delete");
    JButton btnExit = new JButton("EXIT");
   
    
    @Override
    public void actionPerformed(ActionEvent y){
        
        
        
        
        deleteFrame.setSize(400,200);
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.add(deletePanel);
        deletePanel.setLayout(null);
        deletePanel.setBounds(800, 800, 200, 100);
        deletePanel.add(lblFilename);
        lblFilename.setBounds(25,50, 150, 30);
        deletePanel.add(fldFilename);
        fldFilename.setBounds(145,50, 200, 30);
        
        deletePanel.add(btnDelete);
        btnDelete.setBounds(105, 100, 80, 30);
        btnDelete.addActionListener(new deleteButton());
        deletePanel.add(btnExit);
        btnExit.setBounds(195, 100, 80, 30);
        btnExit.addActionListener(new exitButton());
        
        deleteFrame.setVisible(true);
        
        
    }
    public class deleteButton implements ActionListener{
        String filename = fldFilename.getText() + ".txt" ;
        JFrame sureFrame  = new JFrame("CONFIRMATION");
        JPanel surePanel = new JPanel();
        JLabel lblSure = new JLabel("Delete file?");
        JButton btnYes = new JButton("YES");
        JButton btnNo = new JButton("NO");
        @Override
        public void actionPerformed(ActionEvent l){
            
            
            sureFrame.setSize(400,200);
            sureFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            sureFrame.setLocationRelativeTo(null);
            sureFrame.add(surePanel);
            surePanel.setLayout(null);
            surePanel.setBounds(800, 800, 200, 100);
            surePanel.add(lblSure);
            lblSure.setBounds(160, 60, 200, 20);
            
            surePanel.add(btnYes);
            btnYes.setBounds(120, 100, 60, 30);
            btnYes.addActionListener(new yesButton());
            surePanel.add(btnNo);
            btnNo.addActionListener(new noButton());
            btnNo.setBounds(200,100, 60, 30);
            sureFrame.setVisible(true);
            
        }
        public class yesButton implements ActionListener{
             JFrame successFrame =  new JFrame("SUCCESS");
             JPanel successPanel = new JPanel();
             JLabel lblSuccess = new JLabel("File Successfully Deleted.");
             JFrame failFrame =  new JFrame("FAILED");
             JPanel failPanel = new JPanel();
             JLabel lblFail = new JLabel("File cannot be deleted.");
             JButton btnOkay = new JButton("OKAY");
            @Override
            public void actionPerformed(ActionEvent k){
               String filename = "C:\\Users\\Grapevine Homecare\\Documents\\Patients\\" + fldFilename.getText() + ".txt" ;
  
               System.out.print(filename);
                
               try{
                    boolean isDeleted = true;
                    
                    isDeleted = Files.deleteIfExists(Paths.get(filename));
                    
                    if(isDeleted){
                       
                        
                        successFrame.add(successPanel);
                        successFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        successFrame.setLocationRelativeTo(null);
                        successFrame.setSize(400,200);
                        successPanel.setLayout(null);
                        successPanel.setBounds(800, 800, 200, 100);
                        successPanel.add(lblSuccess);
                        lblSuccess.setBounds(120, 60, 200, 20);
                        successPanel.add(btnOkay);
                        btnOkay.setBounds(140, 100, 100, 30);
                        btnOkay.addActionListener(new okayButton1());
                        
                        
                        successFrame.setVisible(true);
                    }
                    else{
                       
                        
                        failFrame.add(failPanel);
                        failFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        failFrame.setLocationRelativeTo(null);
                        failFrame.setSize(400,200);
                        failPanel.setLayout(null);
                        failPanel.setBounds(800, 800, 200, 100);
                        failPanel.add(lblFail);
                        lblFail.setBounds(130, 60, 200, 20);
                        failPanel.add(btnOkay);
                        btnOkay.setBounds(140, 100, 100, 30);
                        btnOkay.addActionListener(new okayButton2());
                        
                        
                        failFrame.setVisible(true);
                
                            
                        
                    }
                    
                }
                catch(DirectoryNotEmptyException dne){
                    System.out.print("Directory is not empty.");
                }
                catch(IOException e){
                    e.printStackTrace(); 
                }
            }
            public class okayButton1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent f){
                sureFrame.dispose();
                successFrame.dispose();
                
                
                
            }
        }
        public class okayButton2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent f){
                sureFrame.dispose();
                failFrame.dispose();
                
                
                
            }
        }
        }
        public class noButton implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent h){
                sureFrame.dispose();
            }
        }
        
    }
    public class exitButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent v){
            deleteFrame.dispose();
        }
    }
}
