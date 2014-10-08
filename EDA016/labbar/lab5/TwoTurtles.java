package lab5;
import java.util.Random;

import se.lth.cs.window.SimpleWindow;

public class TwoTurtles {
	public static void main(String[] args)	{
		
		SimpleWindow w = new SimpleWindow(500, 500, "Thousand Steps");
		ColorTurtle t1 = new ColorTurtle(w, 250, 250, java.awt.Color.RED);
		ColorTurtle t2 = new ColorTurtle(w, 350, 350, java.awt.Color.BLUE);
		t1.penDown();
		t2.penDown();
		Random rand = new Random();
		int xDist = t1.getX() - t2.getX();
		int yDist = t1.getY() - t2.getY();
		double dist = Math.hypot(xDist, yDist);

		
		while (dist >= 50)	{
			t1.forward(rand.nextInt(10) + 1);
			t1.left(rand.nextInt(360)-180);
			t2.forward(rand.nextInt(10) + 1);
			t2.left(rand.nextInt(360)-180);
			
			xDist = t1.getX() - t2.getX();
			yDist = t1.getY() - t2.getY();
			dist = Math.hypot(xDist, yDist);
			
			SimpleWindow.delay(10);
		}
		
	}

}
