/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ımageeffect;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author acer
 */
public class ImagePanel extends javax.swing.JPanel {
    private BufferedImage image = new BufferedImage(200,200,BufferedImage.TYPE_3BYTE_BGR);
    private ButtonPanel bp=null;
    private BufferedImage imagetmp = new BufferedImage(200,200,BufferedImage.TYPE_3BYTE_BGR);
    private File currentFile;
    private int bright;
    private int redVal;
    private int greenVal;
    private int blueVal;
    private int colorVal;
    /**
     * Creates new form ImagePanel
     */
    public ImagePanel() {
        initComponents();
    }
    void setCurrentFile(File of){
       currentFile = of;
    }
    public void setBP(ButtonPanel bp){
    
       this.bp=bp;
      
    }
    public void setImage(BufferedImage image){
    
        this.image=image;
        repaint();
    
    }
    private BufferedImage cloneImage(BufferedImage img){
        int w=img.getWidth();
        int h=img.getHeight();
        BufferedImage image = new BufferedImage(w,h,BufferedImage.TYPE_3BYTE_BGR);
    
        for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
               int pixel = img.getRGB(xx, yy);
                 
               image.setRGB(xx, yy, pixel);
            }   
        }
        
      return image;
    }
     @Override
    public void paintComponent(Graphics g){
    
        g.setColor(Color.white);
        g.fillRect(0, 0, 1690, 1000);
        int w=image.getWidth();
        int h=image.getHeight();
        
        imagetmp = cloneImage(image);
        
        Graphics2D sekil = imagetmp.createGraphics();
        
        if(bp.getEffect1()){
            for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                
             imagetmp.setRGB(xx, yy, (new Color(green,blue,red).getRGB()));
              
             }
           }
        }
        if(bp.getEffect2()){
             for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                
             imagetmp.setRGB(xx, yy, (new Color(red/2,green/2,blue/2).getRGB()));
              
             }
           }
        }
        if(bp.getEffect3()){
            for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int color=(red+green+blue)*2/9;
                  
                
             imagetmp.setRGB(xx, yy, (new Color(color,color,color).getRGB()));
              
             }
           } 
        }
        if(bp.getEffect4()){
             for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int color=(red+blue+green)*30/100;
                  int color2=(blue+green)*5/100;
                  int color3=(green+red)*8/100;
              imagetmp.setRGB(xx, yy, (new Color(color,color2,color3).getRGB()));
              
             }
           } 
            
        }
        if(bp.getEffect5()){
            for(int xx=0; xx<w; xx+=3/*This is not mistake.I wrote for getting that effect:)*/){
              for(int yy=0; yy<h; yy+=3){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int color=(blue+green)*5/100;
                  int color2=(green+red)*8/100;
              imagetmp.setRGB(xx, yy, (new Color(color,color,color2).getRGB()));
              
             }
           } 
        }
        if(bp.getEffect6()){
            for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int color=255-red;
                  int color2=255-green;
                  int color3=255-blue;
                  
                  
                  imagetmp.setRGB(xx, yy, (new Color(color2,color2,color3).getRGB()));
              
              }
            
            }
          
        }
        
        //Brightness
        
        for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int bRed = (red+red*bright/100)>255? 255 :(red+red*bright/100)<0? 0 :(red+red*bright/100);
                  int bGreen = (green+green*bright/100)>255? 255 :(green+green*bright/100)<0? 0 :(green+green*bright/100);
                  int bBlue = (blue+blue*bright/100)>255? 255 :(blue+blue*bright/100)<0? 0 :(blue+blue*bright/100);
                
             imagetmp.setRGB(xx, yy, (new Color(bRed,bGreen,bBlue).getRGB()));
              
             }
           } 
        
        //Red
         for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int bRed = (red+red*redVal/100)>255? 255 :(red+red*redVal/100)<0? 0 :(red+red*redVal/100);
                  int bGreen = (green+green*greenVal/100)>255? 255 :(green+green*greenVal/100)<0? 0 :(green+green*greenVal/100);
                  int bBlue = (blue+blue*blueVal/100)>255? 255 :(blue+blue*blueVal/100)<0? 0 :(blue+blue*blueVal/100);
                
             imagetmp.setRGB(xx, yy, (new Color(bRed,bGreen,bBlue).getRGB()));
              
             }
           } 
         //Color
         
          for(int xx=0; xx<w; xx++){
              for(int yy=0; yy<h; yy++){
            
                  int pixel = imagetmp.getRGB(xx, yy);
                  int red = (pixel>>16) & 0x0ff;
                  int green =(pixel>>8) &0x0ff;
                  int blue = (pixel) & 0x0ff;
                  
                  int bRed = (red+red*colorVal/100)>255? 255 :(red+red*colorVal/100)<0? 0 :(red+red*colorVal/100);
                  int bGreen = (green+green*colorVal/100)>255? 255 :(green+green*colorVal/100)<0? 0 :(green+green*colorVal/100);
                  int bBlue = (blue+blue*colorVal/100)>255? 255 :(blue+blue*colorVal/100)<0? 0 :(blue+blue*colorVal/100);
                
             imagetmp.setRGB(xx, yy, (new Color(bRed,bGreen,bBlue).getRGB()));
              
             }
           } 
        
        g.drawImage(imagetmp,10,10,image.getWidth(),image.getHeight(),this);  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(500, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    void save(){
      
       saveAs();
    
    }
    
    
    void saveAs() {
      JFileChooser fileChooser =new JFileChooser();
      fileChooser.setDialogTitle("Specify a file to save");
      
      fileChooser.setAcceptAllFileFilterUsed(false);
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files","png","jpg","jpeg");
      fileChooser.addChoosableFileFilter(filter);
      
      int act = fileChooser.showSaveDialog(this);
      
      if (act == JFileChooser.APPROVE_OPTION){
        File fileToSave = fileChooser.getSelectedFile();
        currentFile = fileToSave; 
      
      
      try{
        
          ImageIO.write(imagetmp, "png", fileToSave);
        
      }
      catch (IOException ex){
       
          System.out.println("Unsuccess");
      
      }
      }
    }
  
    void setBrightness(int value) {
       this.bright = value*3/2;
    }
    void setRed(int value){
       this.redVal=value;
    }
    void setGreen(int value){
       this.greenVal=value;
    }
    void setBlue(int value){
       this.blueVal=value;
    }

    void setColor(int value) {
        this.colorVal=value*3/2;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
