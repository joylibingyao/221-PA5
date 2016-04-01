/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa5;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author bingyaoli
 */
class SettingPanel extends JPanel {
    private UpperRowPanel upperRowPanel = new UpperRowPanel();
    private LowerRowPanel lowerRowPanel = new LowerRowPanel();
    
    public SettingPanel(){
        GridLayout mGridLayout = new GridLayout(2,1);
        setLayout(mGridLayout);
        add(upperRowPanel);
        add(lowerRowPanel);
    }
    
    public String getShape(){
        return upperRowPanel.GetShape();
    }
    public boolean isFilled(){
        return upperRowPanel.isFilled();
    }
    
    public boolean isGradient(){
        return lowerRowPanel.isGradient();
    }
    public Color getFirstCol(){
        return lowerRowPanel.getFirstCol();
    }
    public Color getSecondCol(){
        return lowerRowPanel.getSecondCol();
    }
    public int getLineWidth(){
        return lowerRowPanel.getLineWidth();
    }
    public boolean isDashed(){
        return lowerRowPanel.isDashed();
    }
    public int getDashLength(){
        return lowerRowPanel.getDashLength();
    }

    void setOnclick(DrawingPanel drawPan) {
        upperRowPanel.SetOnClick(drawPan);
    }

}

