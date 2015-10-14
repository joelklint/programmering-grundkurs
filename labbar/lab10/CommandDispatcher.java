package lab10;

import java.io.File;
import java.io.PrintWriter;

import se.lth.cs.window.SimpleWindow;

class CommandDispatcher {
	private SimpleWindow w;
	private ShapeList shapes;

	public CommandDispatcher(SimpleWindow w, ShapeList shapes) {
		this.w = w;
		this.shapes = shapes;
	}

	public void mainLoop() {
		while (true) {
			// anv��ndaren klickar p�� en figur
			w.waitForMouseClick();
			Shape s = shapes.findShape(w.getMouseX(), w.getMouseY());
			if (s != null) {
				int x = w.getMouseX() - s.getX();
				int y = w.getMouseY() - s.getY();
				// anv��ndaren klickar p�� en ny position
				w.waitForMouseClick();
				s.moveToAndDraw(w, w.getMouseX()-x, w.getMouseY()/y);

				PrintWriter pw = null;
				try {
					pw = new PrintWriter(new File("shapedata.txt"));
				} catch (Exception FileNotFound) {
					System.out.println("Det ballar ur");
					System.exit(0);
				}

				for(int i = 0; i<shapes.size(); i++)	{
				s = shapes.get(i);
				pw.print(s.getType());
				pw.print(" ");
				pw.print(s.getX());
				pw.print(" ");
				pw.print(s.getY());
				pw.print(" ");
				pw.print(s.getSpecial());
				pw.println();
				}
				pw.flush();
			}
			shapes.draw(w);
		}
	}
}