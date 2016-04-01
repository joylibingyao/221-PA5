/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author bingyaoli
 */
class LowerRowPanel extends JPanel{
    private JCheckBox gradientCheckB = new JCheckBox("Use Gradient");
    private JButton firstCol = new JButton("1st Color");
    private final JButton secondCol = new JButton("2nd Color");
    private JLabel lineWidthLab = new JLabel("Line Width:");
    private JTextField lineTextF = new JTextField ("3",2);
    private JLabel lengthLab = new JLabel("Dash Length:");
    private JTextField dasheTextF = new JTextField ("10",2);
    private JCheckBox dashBox = new JCheckBox("Dashed");
    
    private Color defaultCol1 = Color.BLACK;
    private Color defaultCol2 = Color.BLACK;
    
    public LowerRowPanel(){
        FlowLayout mFlowLayout = new FlowLayout();
        setLayout(mFlowLayout);
        mFlowLayout.setAlignment(FlowLayout.CENTER);
        
        add(gradientCheckB);
        add(firstCol);
        add(secondCol);
        add(lineWidthLab);
        add(lineTextF);
        add(lengthLab);
        add(dasheTextF);
        add(dashBox);
        
        firstCol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                defaultCol1 = JColorChooser.showDialog(null, "Pick a color", defaultCol1);
                if(defaultCol1==null)
                {
                    defaultCol1=Color.BLACK;
                }
            }
        });
        secondCol.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                defaultCol2 = JColorChooser.showDialog(null, "Pick a color", defaultCol2);
                if(defaultCol2==null)
                {
                    defaultCol2=Color.BLACK;
                }
            }
        });
//        lineTextF.addActionListener(new ActionListener(){
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lineTextF.setText(TOOL_TIP_TEXT_KEY);
//            }
//
//        });
//        
        
    }
    
    public boolean isGradient(){
        return gradientCheckB.isSelected();
    }
    
    public Color getFirstCol(){
        return defaultCol1;
    }
    public Color getSecondCol(){
        return defaultCol2;
    }
            
    public int getLineWidth(){
        
        return  Integer.parseInt(lineTextF.getText());
    }
    
    public int  getDashLength(){
        return  Integer.parseInt(dasheTextF.getText());

    }
        
    
    public boolean isDashed(){
        return dashBox.isSelected();
    }
        
}
