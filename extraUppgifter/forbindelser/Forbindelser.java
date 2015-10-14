package forbindelser;

import java.awt.Point;
import java.util.Scanner;

import se.lth.cs.window.SimpleWindow;

public class Forbindelser {
	public static void main(String[] args)	{
		
		SimpleWindow w = new SimpleWindow(600, 600, "Förbindelser");
		Scanner scan = new Scanner(System.in);
		System.out.println("Hur många hörn ska din polygon ha?");
		int corners = scan.nextInt();
		scan.close();
		double vinkel = Math.toRadians(360/corners);
		int midX = w.getWidth()/2;
		int midY = w.getHeight()/2;
		int length;
		if(w.getHeight() < w.getWidth())
			length = w.getHeight()/3;
		else
			length = w.getWidth()/3;
		
		Point[] corner = new Point[corners];
		
		//Skapar alla punkter
		for(int i = corners - 1; i>-1; i--)	{
			w.moveTo((int)(midX + Math.round(length*Math.cos(i*vinkel))), (int)(midY + Math.round(length*Math.sin(i*vinkel))));
			corner[i] = new Point(w.getX(), w.getY());
		}
		
//		Förbinder alla punkter med varandra
		for(int i = corner.length-1; i>0; i--)	{
			for(int a = 0; a< corner.length; a++)	{
				w.moveTo(corner[i].x, corner[i].y);
				w.lineTo(corner[a].x, corner[a].y);
			}
			
		}
		
	}
}
