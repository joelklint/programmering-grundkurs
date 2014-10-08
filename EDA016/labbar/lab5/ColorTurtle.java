package lab5;
import java.awt.Color;

import lab4.Turtle;
import se.lth.cs.window.SimpleWindow;

public class ColorTurtle extends Turtle {
	private Color color;
	
	/** Skapar en sköldpadda som ritar i ritfönstret w med färgen color.
		Från början befinnner sig sköldpaddan i punkten x,y med
		pennan lyft och huvudet pekande rakt uppåt i fönstret, dvs i 
		negativ y-riktning */
	public ColorTurtle(SimpleWindow w, int x, int y, Color color) {
		super(w, x, y);
		this.color = color;
	}

	/** Går framåt n pixlar i den riktning huvudet pekar */
	public void forward(int n) {
		Color savedColor = w.getLineColor();
		w.setLineColor(color);
		super.forward(n);
		w.setLineColor(savedColor);
	}
}
