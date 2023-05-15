/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package GUI;
import Comp_Decomp.Compressor;
import Comp_Decomp.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author chinna
 */
public class AppFrame extends JFrame implements ActionListener{
    JButton compressbutton;
    JButton decompressbutton;
    AppFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    compressbutton=new JButton("Select file to compress");
    
    compressbutton.setBounds(20,100,100,30);
    compressbutton.addActionListener(this);
    decompressbutton=new JButton("Select file to decompress");
    decompressbutton.setBounds(250,100,100,30);
    decompressbutton.addActionListener(this);
    this.add(compressbutton);
    this.add(decompressbutton);
    this.setSize(1000,500);
    this.getContentPane().setBackground(Color.green);
    this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        //if we pressed the compress button;
        if (e.getSource()==compressbutton){
            //JFileChooser helps to choose any file from our system
        JFileChooser filechooser=new JFileChooser();
         int response=filechooser.showSaveDialog(null);
         if (response==JFileChooser.APPROVE_OPTION){
             //Path of file saved in file
            File file=new File(filechooser.getSelectedFile().getAbsolutePath());
            System.out.print(file);
            try{
                Compressor.method(file);
            }
            catch(IOException ee){
                JOptionPane.showMessageDialog(null, ee.toString());
            }
         }
        
        }
        if (e.getSource()==decompressbutton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            if (response==JFileChooser.APPROVE_OPTION){
                File file=new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompress.method(file);
                    }
                catch(IOException ee){
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
                }
        }
        
    }
}
