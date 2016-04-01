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
public class Line extends Shape {
    private String shape = "Line";
    private boolean isGradient;
    private Color firstCol ;
    private Color secondCol;
    private int lineWidth;
    private boolean isDashed;
    private int dashLength;
    
    public Line(int currentSTX, int currentSTY, int currentEDX, int currentEDY
            ,boolean isGradient
            ,Color firstCol
            ,Color secondCol
            ,int lineWidth
            ,boolean isDashed
            ,int dashLength) {
        super(currentSTX, currentSTY, currentEDX, currentEDY);
        
	this.isGradient = isGradient;
	this.firstCol = firstCol;
	this.secondCol = secondCol;
	this.lineWidth = lineWidth;
	this.isDashed = isDashed;
	this.dashLength = dashLength;
    }

    /**
     * @return the shape
     */
    @Override
    public String getShape() {
        return shape;
    }
    @Override
    public boolean isGradient() {
        return isGradient;
    }

    /**
     * @param isGradient the isGradient to set
     */
    public void setIsGradient(boolean isGradient) {
        this.isGradient = isGradient;
    }

    /**
     * @return the firstCol
     */
    @Override
    public Color getFirstCol() {
        return firstCol;
    }

    /**
     * @param firstCol the firstCol to set
     */
    public void setFirstCol(Color firstCol) {
        this.firstCol = firstCol;
    }

    /**
     * @return the secondCol
     */
    @Override
    public Color getSecondCol() {
        return secondCol;
    }

    /**
     * @param secondCol the secondCol to set
     */
    public void setSecondCol(Color secondCol) {
        this.secondCol = secondCol;
    }

    /**
     * @return the lineWidth
     */
    @Override
    public int getLineWidth() {
        return lineWidth;
    }

    /**
     * @param lineWidth the lineWidth to set
     */
    public void setLineWidth(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    /**
     * @return the isDashed
     */
    @Override
    public boolean isDashed() {
        return isDashed;
    }

    /**
     * @param isDashed the isDashed to set
     */
    public void setIsDashed(boolean isDashed) {
        this.isDashed = isDashed;
    }

    /**
     * @return the dashLength
     */
    @Override
    public int getDashLength() {
        return dashLength;
    }

    /**
     * @param dashLength the dashLength to set
     */
    public void setDashLength(int dashLength) {
        this.dashLength = dashLength;
    }

    @Override
    public boolean isFilled() {
        return false;
    }
    
    
}
