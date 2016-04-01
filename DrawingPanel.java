/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author bingyaoli
 */
class DrawingPanel extends JPanel{
    private int currentSTX;//current start point
    private int currentSTY;
    private int currentEDX;//current end point
    private int currentEDY;
    
    private String currentShape;
    private boolean isFilled;
    private boolean isGradient;
    private Color firstCol;
    private Color secondCol;
    private int lineWidth;
    private boolean isDashed;
    private int dashLength;
    private ArrayList<Shape> shapeList = new ArrayList<Shape>();
//    private Shape[] shapeList = new Shape[200];
    private int count = 0;
    
    public DrawingPanel(){
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(400,400));
    }
    
    public void startPoint(){
        
    }
    public void collectSettings(String currentShape
                                ,boolean isFilled
                                ,boolean isGradient
                                ,Color firstCol
                                ,Color secondCol
                                ,int lineWidth
                                ,boolean isDashed
                                ,int dashLength){
//        System.out.print(currentShape);
        this.currentShape = currentShape;
        this.isFilled = isFilled;
        this.isGradient = isGradient;
        this.firstCol = firstCol;
        this.secondCol = secondCol;
        this.lineWidth = lineWidth;
        this.isDashed = isDashed;
        this.dashLength = dashLength;
        
    }
    public void createShape(){
        if (currentShape.equals("Line"))
        {
            Line currentLine = new Line(currentSTX,currentSTY,currentEDX,currentEDY,isGradient,firstCol, secondCol, lineWidth,isDashed, dashLength);
            shapeList.add(currentLine);
            count++;
        }
        else if(currentShape.equals("Oval"))
        {
            Oval currentOval = new Oval(currentSTX,currentSTY,currentEDX,currentEDY,isFilled,isGradient,firstCol, secondCol, lineWidth,isDashed, dashLength);
            shapeList.add(currentOval);
            count++;
        }else{
            Rectangle currentRect = new Rectangle(currentSTX,currentSTY,currentEDX,currentEDY,isFilled,isGradient,firstCol, secondCol, lineWidth,isDashed, dashLength);
            shapeList.add(currentRect);
            count++;
        } 
    }
    
    public void mouseDragging(int EDX, int EDY){
        Shape s = shapeList.get(count-1);
        
        if(s.getShape().equals("Line")){
            s.setEDX(EDX);
            s.setEDY(EDY);  
        }
        if(s.getShape().equals("Rectangle")||s.getShape().equals("Oval")){
            int x = s.getOriX();
            int y = s.getOriY();

                s.setSTX(Math.min(x,EDX)); 
                s.setSTY(Math.min(y,EDY)); 
                s.setEDX(Math.max(x,EDX));
                s.setEDY(Math.max(y,EDY));
        }
        

    }
    
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);
        
        for (int i = 0; i< shapeList.size(); i++){
            
            Shape s = shapeList.get(i);
            g2.setPaint(s.getFirstCol());
            g2.setStroke(new BasicStroke(s.getLineWidth()));
            
            if(s.isDashed()==true)
            {
                Stroke dashed = new BasicStroke(s.getLineWidth()
                        , BasicStroke.CAP_BUTT
                        , BasicStroke.JOIN_BEVEL
                        , 0
                        , new float[]{s.getDashLength()}, 0);
                g2.setStroke(dashed);
            }
            if(s.isFilled()==true){
                    g2.setPaint(s.getFirstCol());

            }
            
            if(s.isGradient()){
                        GradientPaint gradientColor = new GradientPaint(s.getSTX()
                                , s.getSTY(), s.getFirstCol()
                                , s.getEDX(), s.getEDY(), s.getSecondCol());
                         g2.setPaint(gradientColor);
                        
            }
            
            
            if(s.getShape().equals("Line")){

                g2.drawLine(s.getSTX(),s.getSTY(),s.getEDX(),s.getEDY());
               
            }
            else if(s.getShape().equals("Rectangle")){
                
               if(s.isFilled()==true){
                   
                   g2.fillRect(s.getSTX(), s.getSTY(),Math.abs( s.getEDX()-s.getSTX()), Math.abs(s.getEDY()-s.getSTY()));
               }else{
                   g2.drawRect(s.getSTX(), s.getSTY(),Math.abs( s.getEDX()-s.getSTX()), Math.abs(s.getEDY()-s.getSTY()));
               }

            }
            else{
                if(s.isFilled()==true){
                   
                   g2.fillOval(s.getSTX(), s.getSTY(),Math.abs( s.getEDX()-s.getSTX()), Math.abs(s.getEDY()-s.getSTY()));
               }else{
                   g2.drawOval(s.getSTX(), s.getSTY(),Math.abs( s.getEDX()-s.getSTX()), Math.abs(s.getEDY()-s.getSTY()));
               }

            }
        }
    }

    public void ChearPan() {
        shapeList.clear();
        count=0;
        repaint();
    }

    public void Undo() {
        if(shapeList.size()!=0){
            shapeList.remove(shapeList.size()-1);
            count--;
            repaint();
        }
    }

    /**
     * @return the currentSTX
     */
    public int getCurrentSTX() {
        return currentSTX;
    }

    /**
     * @param currentSTX the currentSTX to set
     */
    public void setCurrentSTX(int currentSTX) {
        this.currentSTX = currentSTX;
    }

    /**
     * @return the currentSTY
     */
    public int getCurrentSTY() {
        return currentSTY;
    }

    /**
     * @param currentSTY the currentSTY to set
     */
    public void setCurrentSTY(int currentSTY) {
        this.currentSTY = currentSTY;
    }

    /**
     * @return the currentEDX
     */
    public int getCurrentEDX() {
        return currentEDX;
    }

    /**
     * @param currentEDX the currentEDX to set
     */
    public void setCurrentEDX(int currentEDX) {
        this.currentEDX = currentEDX;
    }

    /**
     * @return the currentEDY
     */
    public int getCurrentEDY() {
        return currentEDY;
    }

    /**
     * @param currentEDY the currentEDY to set
     */
    public void setCurrentEDY(int currentEDY) {
        this.currentEDY = currentEDY;
    }
    
}
