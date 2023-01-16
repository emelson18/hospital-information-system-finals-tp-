package tryhis;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;


public class ReadButton implements ActionListener{
    
    String fileName, fileAddress;
    JFrame readFrame = new JFrame("READ");
    JPanel readPanel = new JPanel();
    JTextArea readArea = new JTextArea(21,55);
    Border blackline = BorderFactory.createCompoundBorder(BorderFactory.
         createBevelBorder(BevelBorder.RAISED),BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    JButton btnDone = new JButton("DONE");
    Font setFont = new Font("",Font.TRUETYPE_FONT,18);
    
    FlowLayout f1 = new FlowLayout();
    
    @Override
    public void actionPerformed(ActionEvent x){
    FileDialog fd = new FileDialog(readFrame, "READ", FileDialog.LOAD);
    fd.setVisible(true);
    
    readArea.setText("");
    
    if(fd.getFile() != null){
       fileName = fd.getFile();
       fileAddress = fd.getDirectory();
    }
    try{
        try (BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName))) {
            String line = null;
                while((line = br.readLine())!=null){
                    readArea.append(line + "\n");
                }
                br.close();
        }
    }catch(Exception e){
        System.out.println("File cannot be loaded.");
    }
    readFrame.setSize(800,600);
    readFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    readFrame.setLocationRelativeTo(null);
    readFrame.add(readPanel);
    readPanel.setSize(800,500);
    
    
    readPanel.add(readArea);
    readArea.setBorder(blackline);
    readArea.setFont(setFont);
    readArea.setEditable(false);
    readPanel.add(btnDone);
    btnDone.addActionListener(new doneButton());
    
    
    readFrame.setVisible(true);
    
}
    public class doneButton implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent s){
            readFrame.dispose();
            
        }
    }
    
    
}
