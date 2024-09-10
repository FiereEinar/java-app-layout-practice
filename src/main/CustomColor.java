package main;

import java.awt.Color;

public class CustomColor extends Color {
	private static final long serialVersionUID = 1L;
	
	public static Color dark = new Color(0x1c1e21);
	public static Color dark_100 = new Color(0x242526);
	public static Color dark_200 = new Color(0x3a3b3c);
	public static Color dark_300 = new Color(0x3e4042);
	public static Color dark_400 = new Color(0x65676b);
	public static Color dark_500 = new Color(0xbcc0c4);
	public static Color danger = new Color(0xb00020);
	
	public CustomColor(int rgb) {
		super(rgb);
	}

}
