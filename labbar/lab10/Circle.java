package lab10;

import java.awt.Point;
import java.util.ArrayList;
import se.lth.cs.window.SimpleWindow;


public class Circle extends Shape {

	private int radie;

	public Circle(int x, int y, int radie) {
		super(x, y);
		this.radie = radie;
	}

	public void draw(SimpleWindow w) {
		double vinkel = Math.toRadians(1);
		Point[] corner = new Point[362];
		// Skapar alla punkter
		for (int i = 1; i < 362; i++) {
			w.moveTo((int) (x + Math.round(radie * Math.cos(i * vinkel))),
					(int) (y + Math.round(radie * Math.sin(i * vinkel))));
			corner[i] = new Point(w.getX(), w.getY());
		}

		// F��rbinder alla punkter med varandra
		for (int i = 1; i < 361; i++) {
			w.moveTo(corner[i].x, corner[i].y);
			w.lineTo(corner[i + 1].x, corner[i + 1].y);

		}
	}

	public char getType() {
		return 'C';
	}

	public int getSpecial() {
		return radie;
	}
	public boolean hasShapeAt(int xc, int yc)	{
		ArrayList<Point> pixels = new ArrayList<Point>();
		
		for(int i = 0; i<=90; i++)		{
			double xVinkel = Math.toRadians(i);
			double xNVinkel = Math.toRadians(180-i);
			for(int j = 0; j<radie*Math.toRadians(i); j = j+1)		{
				double yVinkel = Math.toRadians(j);
				double yNVinkel = Math.toRadians(180-j);
				int pixelX = (int)(x+radie*Math.cos(xVinkel));
				int pixelY = (int)(y+radie*Math.sin(yVinkel));
				pixels.add(new Point(pixelX, pixelY));
				pixelX = (int)(x+radie*Math.cos(-xVinkel));
				pixelY = (int)(y+radie*Math.sin(-yVinkel));
				pixels.add(new Point(pixelX, pixelY));
				pixelX = (int)(x+radie*Math.cos(xNVinkel));
				pixelY = (int)(y+radie*Math.sin(yNVinkel));
				pixels.add(new Point(pixelX, pixelY));
				pixelX = (int)(x+radie*Math.cos(-xNVinkel));
				pixelY = (int)(y+radie*Math.sin(-yNVinkel));
				pixels.add(new Point(pixelX, pixelY));
			}
		}
		Point mouseClick = new Point(xc, yc);
		if(pixels.contains(mouseClick))	{
			return true;
		}
		return false;
	}
	
}
