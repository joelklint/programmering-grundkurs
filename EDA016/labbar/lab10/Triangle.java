package lab10;

import java.awt.Point;

import se.lth.cs.window.SimpleWindow;

public class Triangle extends Shape {

	private int side;
	private Point[] point;

	public Triangle(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	public void draw(SimpleWindow w) {
		point = new Point[3];
		for (int i = 0; i < 3; i++) {
			int newX = (int) (x + Math.round(side
					* Math.cos(Math.toRadians(120 * i))));
			int newY = (int) (y - Math.round(side
					* Math.sin(Math.toRadians(120 * i))));
			point[i] = new Point(newX, newY);
			w.moveTo(newX, newY);
			w.lineTo(x, y);
			x = newX;
			y = newY;
		}
	}

	public char getType() {
		return 'T';
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getSpecial() {
		return side;
	}

	public boolean hasShapeAt(int xc, int yc) {
		int x1 = point[0].x;
		int x2 = point[1].x;
		int x3 = point[2].x;
		int y1 = point[0].y;
		int y2 = point[1].y;
		int y3 = point[2].y;
		int totArea = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2) / 2;
		int areaA = xc * (y2 - y3) + x2 * (y3 - yc) + x3 * (yc - y2) / 2;
		int areaB = x1 * (yc - y3) + xc * (y3 - y1) + x3 * (y1 - yc) / 2;
		int areaC = x1 * (y2 - yc) + x2 * (yc - y1) + xc * (y1 - y2) / 2;
		int tempArea = areaA + areaB + areaC;
		if (tempArea < totArea) {
			return false;
		}
		return false;
	}
}
