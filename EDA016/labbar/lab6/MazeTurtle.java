package lab6;

import lab4.Turtle;
import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.window.SimpleWindow;

public class MazeTurtle extends Turtle {

	public MazeTurtle(SimpleWindow w, int x, int y) {
		super(w, x, y);
	}

	/**
	 * Låter sköldpaddan vandra genom labyrinten maze, från ingången till
	 * utgången
	 */
	public void walk(Maze m) {
		jumpTo(m.getXEntry(), m.getYEntry());
		penDown();

		while (!(m.atExit(super.getX(), super.getY()))) {
			if (!(m.wallAtLeft(super.getDirection(), super.getX(), super.getY()))) {
				super.left(90);
			}
			while (m.wallInFront(super.getDirection(), super.getX(), super.getY())) {
				super.left(270);
			}
			super.forward(1);
			SimpleWindow.delay(5);
		}
	}

}
