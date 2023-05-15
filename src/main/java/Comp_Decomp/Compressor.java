/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author chinna
 */
public class Compressor {
    public static void method(File file) throws IOException{
        //To save the outpot file in same folder we need parent (folder the file contains)
        //So getParent() function will get the parent of the file and stores in string format
        String fileDirectory=file.getParent(); 
        FileInputStream fis=new FileInputStream(file);  //This class used to obtains input byte and reads
           
        //FileOutputStream writes the bytes inside a file and stores the file
        //we are going to push output file in same input path.
        //I want o/p name as compreesed with extension gz;
        FileOutputStream fos=new FileOutputStream(fileDirectory+"/Compressed.gz"); 
        
        //As we want o/p file to be compressed so i will use GZIPOutputStream and i will pass fos;
        //Whatever bytes i am going to write in my o/p file i want those to compress
        GZIPOutputStream gzip=new GZIPOutputStream(fos); //
        
        //Since file is combination of bytes Fis wil obtains the bytes so we need byte array to stroe that bytes
        //with the help of buffer byte i am going to read the data and then write it inside my o/p file
        byte[] buffer=new byte[1024]; 
        
        int len;
        
        //I want to read file inside buffer array until it reaches end of file;
        
        while ((len=fis.read(buffer))!=-1){
            
        //write function help to write len bytes from buffer array to the gzipoutputstream;
        //0 = start, len = n.o of bytes
            gzip.write(buffer,0,len);
        }
        gzip.close();
        fis.close();
        fos.close();
        
    }
    public static void main(String[] args) throws IOException{
        File path=new File("");   //Selected file path stored in path 
        method(path);   
    }
    
}
