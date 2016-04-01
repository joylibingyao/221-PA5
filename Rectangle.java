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
public class Rectangle extends Shape{
    private String shape = "Rectangle";
    private boolean isFilled = false;
    private boolean isGradient;
    private Color firstCol ;
    private Color secondCol;
    private int lineWidth;
    private boolean isDashed;
    private int dashLength;

    public Rectangle(int currentSTX, int currentSTY, int currentEDX, int currentEDY,boolean isFilled ,boolean isGradient,Color firstCol ,Color secondCol,int lineWidth,boolean isDashed,int dashLength) {
        super(currentSTX, currentSTY, currentEDX, currentEDY);
	    this.isGradient = isGradient;
	    this.firstCol  = firstCol ;
	    this.secondCol = secondCol;
	    this.lineWidth = lineWidth;
	    this.isDashed = isDashed;
	    this.dashLength = dashLength;
            this.isFilled = isFilled;
    }

    @Override
    public String getShape() {
        return this.shape;
    }

    @Override
    public boolean isGradient() {
        return this.isGradient;
    }

    @Override
    public Color getFirstCol() {
        return this.firstCol;
    }

    @Override
    public Color getSecondCol() {
        return this.secondCol;
    }

    @Override
    public int getLineWidth() {
        return this.lineWidth;
    }

    @Override
    public boolean isDashed() {
        return this.isDashed;
    }

    @Override
    public int getDashLength() {
        return this.dashLength;
    }

    @Override
    public boolean isFilled() {
        return this.isFilled;
    }
    
}
