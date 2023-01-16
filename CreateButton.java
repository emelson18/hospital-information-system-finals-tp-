/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tryhis;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.nio.file.*;
/**
 *
 * @author Grapevine Homecare
 */
public class CreateButton implements ActionListener{
    
    
    String fileName,fileAddress;
   
    JFrame createFrame = new JFrame("Create");
    JPanel createPanel = new JPanel();
    JButton btnSubmit = new JButton("Submit");
    JButton btnExit = new JButton("EXIT");
    
    JLabel lblFirstName = new JLabel("First Name: ");
    JLabel lblMiddleName = new JLabel("Middle Name: ");
    JLabel lblLastName = new JLabel("Last Name: ");
    JLabel lblDate = new JLabel("Admission Date: ");
    JLabel lblStatus = new JLabel("Patient Status: ");
    
    JTextField fldFirstName = new JTextField(15);
    JTextField fldLastName = new JTextField(15);
    JTextField fldMiddleName = new JTextField(15);
    JTextField fldDate = new JTextField(15);
    JTextField fldStatus = new JTextField(15);
    
    Font setFont = new Font("",Font.TRUETYPE_FONT,18);
    
    @Override
    public void actionPerformed(ActionEvent e ){
        
        //bWindow.setVisible(false);
        
        createFrame.setSize(300,350);
        createFrame.setLocationRelativeTo(null);
        createFrame.setTitle("INPUT");
        createFrame.setResizable(true);
        createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        fldFirstName.setFont(setFont);
        fldMiddleName.setFont(setFont);
        fldLastName.setFont(setFont);
        fldDate.setFont(setFont);
        fldStatus.setFont(setFont);
        
        createPanel.add(lblFirstName);
        createPanel.add(fldFirstName);
        createPanel.add(lblMiddleName);
        createPanel.add(fldMiddleName);
        createPanel.add(lblLastName);
        createPanel.add(fldLastName);
        createPanel.add(lblDate);
        createPanel.add(fldDate);
        createPanel.add(lblStatus);
        createPanel.add(fldStatus);
        
        createFrame.add(createPanel);
        createFrame.setVisible(true);
        
        createPanel.add(btnSubmit);
        btnSubmit.addActionListener(new submitButton());
        createPanel.add(btnExit);
        btnExit.addActionListener(new exitButton());
        
        
        
    }
     public class exitButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent q){
            createFrame.dispose();
        }
    }
 public class submitButton implements ActionListener{
     JFrame outputFrame = new JFrame("Confirm");
     JPanel outputPanel = new JPanel();
     JTextArea outputArea = new JTextArea(21, 55);
     JButton btnOkay = new JButton("Okay");
     JButton btnCancel = new JButton("Cancel");
    
    @Override
    public void actionPerformed(ActionEvent a){
        
        Patients p  = new Patients();
        
        p.setFirstName(fldFirstName.getText()); 
        p.setMiddleName(fldMiddleName.getText());
        p.setLastName(fldLastName.getText())  ;
        p.setAdmissionDate(fldDate.getText());
        p.setStatus(fldStatus.getText());
        
        outputArea.setFont(setFont);
        outputArea.append("\nFirst Name: "+ p.getFirstName() +"\nMiddle Name: " + p.getMiddleName() + "\nLast Name: " + p.getLastName() + "\nDate: " + p.getAdmissionDate() + "\nStatus: " + p.getStatus());
        btnSubmit.setEnabled(false);
      
        outputFrame.setSize(800,600);
        outputFrame.setLocationRelativeTo(null);
        outputFrame.setResizable(false);
        outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        outputFrame.add(outputPanel);
        outputPanel.add(outputArea);
        outputArea.setEditable(false);
        
        outputPanel.add(btnOkay);
        btnOkay.addActionListener(new okayButton());
        outputPanel.add(btnCancel);
        btnCancel.addActionListener(new cancelButton());
        
        outputFrame.setVisible(true);
        }
   
    public class okayButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent b){
            File fileAddress = new File("C:\\Users\\Grapevine Homecare\\Documents\\Patients");
            String fileName =  fldLastName.getText() + ".txt";
            
            
           
                try {
                
                FileWriter fw = new FileWriter(new File(fileAddress,fileName));
                fw.write(outputArea.getText());
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(CreateButton.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            fldLastName.setText("");
            fldFirstName.setText("");
            fldMiddleName.setText("");
            fldDate.setText("");
            fldStatus.setText("");
            createFrame.dispose();
            outputFrame.dispose();
        }
    }
    public class cancelButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent x){
            btnSubmit.setEnabled(true);
            outputFrame.dispose();
            outputArea.setText("");
        }
        }

    }
}
