/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Comp_Decomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author chinna
 */
public class Decompress {
    public static void method(File file) throws IOException{
        
        String fileDirectory=file.getParent();
        // i will read with help of FileInputStream class since the file is compressed so bytes we are getting are compresse
        FileInputStream fis=new FileInputStream(file);
        //The compressed bytes are read by GZIPInputStream
        GZIPInputStream gzip=new GZIPInputStream(fis);
        
        FileOutputStream fos=new FileOutputStream(fileDirectory);
        
        
        byte[] buffer=new byte[1024];
        int len;
        
        
        while ((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fis.close();
        fos.close();
        
    
    }
    public static void main(String[] args) throws IOException{
    File path=new File("");
    method(path);
    }
}
