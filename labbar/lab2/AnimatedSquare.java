package lab2;
import java.util.Scanner;

import se.lth.cs.ptdc.square.Square;
import se.lth.cs.window.SimpleWindow;

public class AnimatedSquare {
	public static void main(String[] args) {
		System.out.println("Skriv förminskning");
		Scanner scan = new Scanner(System.in);
		int dim = scan.nextInt();
		System.out.println("Skriv rotation");
		int rot = scan.nextInt();
		scan.close();
		SimpleWindow w = new SimpleWindow(600, 600, "DrawManySquares");
		Square sq = new Square(300, 300, 200);
		while (true) {
			if(sq.getSide() == 200)	{
				while(sq.getSide() > 0)	{
					sq.draw(w);
					SimpleWindow.delay(50);
					w.clear();
					sq.setSide(sq.getSide() - dim);
					sq.rotate(rot);
				}
			}
			if(sq.getSide() == 0)	{
				while(sq.getSide() < 600)	{
					sq.draw(w);
					SimpleWindow.delay(50);
					w.clear();
					sq.setSide(sq.getSide() + dim);
					sq.rotate(rot);	
				}
			}
			if(sq.getSide() == w.getWidth())	{
				while(sq.getSide() > 0)	{
					sq.draw(w);
					SimpleWindow.delay(50);
					w.clear();
					sq.setSide(sq.getSide() - dim);
					sq.rotate(rot);
				}
			}
		}
	}
}
