package lab10;

import java.awt.Point;
import java.util.ArrayList;

import se.lth.cs.window.SimpleWindow;

public class Square extends Shape {

	private int side;

	public Square(int x, int y, int side) {
		super(x, y);
		this.side = side;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(x, y);
		w.lineTo(x + side, y);
		w.lineTo(x + side, y + side);
		w.lineTo(x, y + side);
		w.lineTo(x, y);
	}

	public char getType() {
		return 'S';
	}

	public int getSpecial() {
		return side;
	}

	public boolean hasShapeAt(int xc, int yc) {
		ArrayList<Point> pixels = new ArrayList<Point>();
		for (int i = 0; i < side; i++) {
			for (int j = 0; j < side; j++) {
				pixels.add(new Point(x + i, y + j));
			}
		}
		Point mouseClick = new Point(xc, yc);
		if (pixels.contains(mouseClick)) {
			return true;
		}
		return false;
	}

}
