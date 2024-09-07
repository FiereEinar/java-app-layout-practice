package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

import main.CustomColor;

public class RoundedButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	private Color originalBackground;
    private Color hoverBackground;
    private Color textColor;
    private Color textHoverColor;

	public RoundedButton(String label) {
        super(label);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusable(false);
        
        originalBackground = CustomColor.dark_300;
        hoverBackground = CustomColor.dark_400;
        textColor = CustomColor.dark_500;
        textHoverColor = CustomColor.dark_500;
        
        addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		super.mouseEntered(e);
        		setBackground(hoverBackground);
        		setForeground(textHoverColor);
        		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        	}
        	
        	@Override
        	public void mouseExited(MouseEvent e) {
        		super.mouseExited(e);
        		setBackground(originalBackground);
        		setForeground(textColor);
        		setCursor(Cursor.getDefaultCursor());
        	}
		});
	}
	
	public void setHoverBackgroundColor(Color hoverColor) {
        this.hoverBackground = hoverColor;
    }
	
	public void setOriginalBackgroundColor(Color originalColor) {
        this.originalBackground = originalColor;
        this.setBackground(originalColor);
    }
	
	public void setForegroundHover(Color textColor) {
		this.textHoverColor = textColor;
	}
	
	public void setForegroundDefault(Color textColor) {
		this.textColor = textColor;
		this.setForeground(textColor);
	}	
	
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20);
        g2.setColor(getBackground());
        g2.fill(roundedRectangle);

        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        Rectangle r = getBounds();
        int x = (r.width - fm.stringWidth(getText())) / 2;
        int y = (r.height - fm.getHeight()) / 2 + fm.getAscent();
        g2.drawString(getText(), x, y);

        g2.dispose();

        super.paintComponent(g);
    }
}