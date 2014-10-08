package lab3;

import se.lth.cs.ptdc.square.Square;
import se.lth.cs.window.SimpleWindow;

public class MouseMoveSquareTrail {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "Square Trail");
		Square sq = new Square(300, 300, 50);
		sq.draw(w);
		while (true) {
			w.waitForEvent();
			// Om du klickar med musen
			if (w.getEventType() == 1) {
				int dx = (w.getMouseX() - sq.getX()) / 10;
				int dy = (w.getMouseY() - sq.getY()) / 10;
				for (int i = 0; i < 10; i++) {
					sq.move(dx, dy);
					sq.draw(w);
				}
			}
			// Om du inte klickar med musen
			else {
				switch (w.getKey()) {
				case 'r':
					w.setLineColor(java.awt.Color.RED);
					break;
				case 'c':
					w.clear();
				default:
					w.setLineColor(java.awt.Color.BLACK);
				}
			}
		}
	}

}
