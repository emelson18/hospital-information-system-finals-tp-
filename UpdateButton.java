/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tryhis;

import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 *
 * @author Grapevine Homecare
 */
public class UpdateButton implements ActionListener{
    String fileName, fileAddress;
    JFrame updateFrame = new JFrame("UPDATE");
    JPanel updatePanel = new JPanel();
    JTextArea updateArea = new JTextArea(21,55);
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.
         createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    JButton btnExit = new JButton("EXIT");
    JButton btnUpdate = new JButton("UPDATE");
    Font setFont = new Font("",Font.TRUETYPE_FONT,18);
    
    FlowLayout f1 = new FlowLayout();
    
    @Override
    public void actionPerformed(ActionEvent x){
    FileDialog fd = new FileDialog(updateFrame, "READ", FileDialog.LOAD);
    fd.setVisible(true);
    
    if(fd.getFile() != null){
       fileName = fd.getFile();
       fileAddress = fd.getDirectory();
    }
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName))) {
            String line = null;
                while((line = br.readLine())!=null){
                    updateArea.append(line + "\n");
                }
        }
    catch(Exception e){
        System.out.println("File cannot be loaded.");
    }
    updateFrame.setSize(800,600);
    updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    updateFrame.setLocationRelativeTo(null);
    updateFrame.add(updatePanel);
    updatePanel.setSize(800,500);
    
    
    updatePanel.add(updateArea);
    updateArea.setBorder(blackline);
    updateArea.setFont(setFont);
    updateArea.setEditable(true);
    updatePanel.add(btnUpdate);
    btnUpdate.addActionListener(new updateButton());
    updatePanel.add(btnExit);
    btnExit.addActionListener(new exitButton());
    
    
    
    updateFrame.setVisible(true);
    
}

    public class updateButton implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent z){
            
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(updateArea.getText());
                fw.close(); 
            }catch(Exception e ){
                System.out.print("Cant save.");
            }
            updateFrame.dispose();
        }
            
            }
        
        
    
    public class exitButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent s){
            updateFrame.dispose();
            
        }
    }
    
}
