package main;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}
	
	public static ImageIcon getImageIcon(String path, int width, int height) {
	    ImageIcon icon = new ImageIcon(path);
	    Image image = icon.getImage();
	
	    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	    
	    return new ImageIcon(scaledImage);
	}

}
