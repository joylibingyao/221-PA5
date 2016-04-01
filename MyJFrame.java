/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author bingyaoli
 */
class MyJFrame extends JFrame implements MouseListener, MouseMotionListener{
    private int mouX;
    private int mouY;
    
    private SettingPanel settingPan = new SettingPanel();
    private DrawingPanel drawPan = new DrawingPanel();
    private JLabel statusLab = new JLabel(",");
    
    
    
    public MyJFrame(){
        setTitle("Java 2D Application");
        BorderLayout mBorderLayout = new BorderLayout();
        setLayout(mBorderLayout);
        
        add(settingPan, BorderLayout.NORTH);
        add(drawPan, BorderLayout.CENTER);
        add(statusLab,BorderLayout.SOUTH);
        
                
        drawPan.addMouseMotionListener(this);
        drawPan.addMouseListener(this);
        settingPan.setOnclick(drawPan);
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
//        System.out.print("2");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        drawPan.setCurrentSTX(e.getX());
        drawPan.setCurrentSTY(e.getY());
        drawPan.setCurrentEDX(e.getX());
        drawPan.setCurrentEDY(e.getY());

        drawPan.collectSettings(settingPan.getShape()
                , settingPan.isFilled()
                , settingPan.isGradient()
                , settingPan.getFirstCol()
                , settingPan.getSecondCol()
                , settingPan.getLineWidth()
                , settingPan.isDashed()
                , settingPan.getDashLength());
        drawPan.createShape();
//        System.out.print("1");
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        drawPan.mouseDragging(e.getX(), e.getY());
        
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
        @Override
    public void mouseEntered(MouseEvent e) {

    }
    
}
