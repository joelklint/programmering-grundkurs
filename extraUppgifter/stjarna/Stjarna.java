package stjarna;

import java.awt.Color;
import java.util.Random;

import se.lth.cs.window.SimpleWindow;

public class Stjarna {
	public static void main(String[] args)	{
		
		Color[] color = new Color[13];
		color[0] = java.awt.Color.BLACK;
		color[1] = java.awt.Color.BLUE;
		color[2] = java.awt.Color.CYAN;
		color[3] = java.awt.Color.DARK_GRAY;
		color[4] = java.awt.Color.GRAY;
		color[5] = java.awt.Color.GREEN;
		color[6] = java.awt.Color.LIGHT_GRAY;
		color[7] = java.awt.Color.MAGENTA;
		color[8] = java.awt.Color.ORANGE;
		color[9] = java.awt.Color.PINK;
		color[10] = java.awt.Color.RED;
		color[11] = java.awt.Color.WHITE;
		color[12] = java.awt.Color.YELLOW;
		
		SimpleWindow w = new SimpleWindow(300, 300, "Stjärna");
		Random rand = new Random();
		int midX = w.getWidth()/2;
		int midY = w.getHeight()/2;
		int length;
		
		for(int i = 0; i<1000; i++)	{
			w.moveTo(midX, midY);
			int col = rand.nextInt(13);
			w.setLineColor(color[col]);
			if(w.getWidth() < w.getHeight())
				length = rand.nextInt(2*w.getWidth()/5);
			else
				length = rand.nextInt(2*w.getHeight()/5);
			w.lineTo((int)(midX + length*Math.cos(Math.toRadians(i))), (int)(midY + length*Math.sin(Math.toRadians(i))));
		}
	}

}
