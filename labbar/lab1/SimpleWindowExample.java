package lab1;

import se.lth.cs.window.SimpleWindow;

public class SimpleWindowExample {
	public static void main(String[] args)	{
		SimpleWindow w = new SimpleWindow(600, 600, "Ett fönster");
		System.out.println("Klicka där du vill starta din linje.");
		w.waitForMouseClick();
		int x = w.getMouseX();
		int y = w.getMouseY();
		w.moveTo(x, y);
		w.writeText("1");
		System.out.println("Klicka där du vill ha nästa punkt.");
		for(int i=2; i<10000;i++)	{
		w.waitForMouseClick();
		x = w.getMouseX();
		y = w.getMouseY();
		w.lineTo(x, y);
		w.writeText(x + "," + y);
		w.writeText(i + "");
		}
		
		
	}

}
