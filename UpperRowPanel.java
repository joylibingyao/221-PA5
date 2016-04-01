/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author bingyaoli
 */
class UpperRowPanel extends JPanel {
    private JButton undoButton = new JButton("Undo");
    private JButton clearButton = new JButton("Clear");
    private JLabel shapeLabel = new JLabel("Shape:");
    private String[] shapeArr ={"Line","Oval","Rectangle"};
    private JComboBox shapeComB = new JComboBox(shapeArr);
    private JCheckBox filledCheckBox = new JCheckBox("Filled");
    
    public UpperRowPanel(){
        
        FlowLayout mFlowLayout = new FlowLayout();
        setLayout(mFlowLayout);
        mFlowLayout.setAlignment(FlowLayout.CENTER);
        
        shapeComB.setSelectedIndex(0);
        
        
        add(undoButton);
        add(clearButton);
        add(shapeLabel);
        add(shapeComB);
        add(filledCheckBox);
    }   
    
    public String GetShape(){
        return (String) shapeComB.getSelectedItem();
        
    }
    public boolean isFilled(){
        return filledCheckBox.isSelected();
    }
    
    public void SetOnClick(DrawingPanel drawPan){
        clearButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPan.ChearPan();
                

            }
        });
        
        undoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                drawPan.Undo();
                
            }
        });
    }
            
}
