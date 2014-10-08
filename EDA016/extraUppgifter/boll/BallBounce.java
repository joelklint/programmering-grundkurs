package boll;

import java.util.Random;
import java.util.Scanner;

import se.lth.cs.window.SimpleWindow;

public class BallBounce {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Hur m��nga bollar vill du ha?");
		int amount = scan.nextInt();
		scan.close();
		SimpleWindow w = new SimpleWindow(600, 300, "Ball Bounce");
		Ball[] ball = new Ball[amount];
		Random rand = new Random();
		for(int i = 0; i<amount; i++)	{
			ball[i] = new Ball(w, 10);
		}
		
		int[] dx = new int[amount];
		int[] dy = new int[amount];
		for(int i = 0; i<amount; i++)	{
			dx[i] = rand.nextInt(5)+3;
//			dy[i] = rand.nextInt(10)+1;
			dy[i] = dx[i]+rand.nextInt(3)+1;
		}
		
		while (true) {
			for(int i = 0; i<amount; i++)	{
				ball[i].draw();
				ball[i].move(dx[i], dy[i]);
			}
			SimpleWindow.delay(10);
			w.clear();
			for(int i = 0; i<amount; i++)	{
				dx[i] = ball[i].changeXIfAtEnd(dx[i]);
				dy[i] = ball[i].changeYIfAtEnd(dy[i]);
			}
		}
	}

}