package lab10;

import java.io.File;
import java.util.Scanner;

import se.lth.cs.window.SimpleWindow;

public class ShapeTest {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "ShapeTest");
		ShapeList shapes = new ShapeList();
		CommandDispatcher com = new CommandDispatcher(w, shapes);
		Scanner scan = null;
		try {
			scan = new Scanner(new File("shapedata.txt"));
		} catch (Exception FileNotFound) {
			System.out.println(
					"File not Found");
			System.exit(0);
		}
		while (scan.hasNext()) {
			// Om det är en fyrkant
			if (scan.hasNext("S")) {
				scan.next();
				int x = scan.nextInt();
				int y = scan.nextInt();
				int side = scan.nextInt();
				Shape s = new Square(x, y, side);
				shapes.insert(s);
			}
			// Om det är en triangel
			if (scan.hasNext("T")) {
				scan.next();
				int x = scan.nextInt();
				int y = scan.nextInt();
				int side = scan.nextInt();
				Shape s = new Triangle(x, y, side);
				shapes.insert(s);
			}
			// Om det är en cirkel
			if (scan.hasNext("C")) {
				scan.next();
				int x = scan.nextInt();
				int y = scan.nextInt();
				int radie = scan.nextInt();
				Shape s = new Circle(x, y, radie);
				shapes.insert(s);
			}
		}
		shapes.draw(w);
		com.mainLoop();
	}
}
