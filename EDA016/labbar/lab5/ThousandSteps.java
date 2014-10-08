package lab5;
import java.util.Random;

import lab4.Turtle;
import se.lth.cs.window.SimpleWindow;

public class ThousandSteps {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(500, 500, "Thousand Steps");
		Turtle t1 = new Turtle(w, 250, 250);
		t1.penDown();
		Random rand = new Random();

		for (int i = 0; i < 1001; i++) {
			t1.forward(rand.nextInt(10) + 1);
			t1.left(rand.nextInt(360));
			SimpleWindow.delay(5);
		}

	}

}
