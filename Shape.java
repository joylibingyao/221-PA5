/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.Color;

/**
 *
 * @author bingyaoli
 */
public abstract class Shape {
    private int oriX =0;
    private int oriY = 0;
    private int STX = 0;//current start point
    private int STY = 0;
    private int EDX = 0;//current end point
    private int EDY = 0;
    
    public Shape(int currentSTX
                ,int currentSTY 
                ,int currentEDX
                ,int currentEDY ){
        this.oriX = currentSTX;
        this.oriY = currentSTY;
        this.STX = currentSTX;
        this.STY = currentSTY;
        this.EDX = currentEDX;
        this.EDY = currentEDY;
        
    }

    public abstract String getShape();
    public abstract boolean isFilled();
    public abstract boolean isGradient();
    public abstract Color getFirstCol();
    public abstract Color getSecondCol();
    public abstract int getLineWidth();
    public abstract boolean isDashed();
    public abstract int getDashLength();


    /**
     * @return the STX
     */
    public int getSTX() {
        return STX;
    }

    /**
     * @return the STY
     */
    public int getSTY() {
        return STY;
    }

    /**
     * @return the EDX
     */
    public int getEDX() {
        return EDX;
    }

    /**
     * @return the EDY
     */
    public int getEDY() {
        return EDY;
    }

    /**
     * @param EDX the EDX to set
     */
    public void setEDX(int EDX) {
        this.EDX = EDX;
    }

    /**
     * @param EDY the EDY to set
     */
    public void setEDY(int EDY) {
        this.EDY = EDY;
    }

    public void setSTX(int STX) {
        this.STX = STX;
    }
     public void setSTY(int STY) {
        this.STY = STY;
    }

    /**
     * @return the oriX
     */
    public int getOriX() {
        return oriX;
    }

    /**
     * @return the oriY
     */
    public int getOriY() {
        return oriY;
    }
    
}
