package boll;

import se.lth.cs.window.SimpleWindow;

public class Pong {

	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 200, "Pong");
		PongPlayer player1 = new PongPlayer(w, 50);
		PongPlayer player2 = new PongPlayer(w, w.getWidth() - 50);
		Ball ball = new Ball(w, 10);
		Thread t1 = new Thread(new GetKey(w, player1, 'w', 's'));
		Thread t2 = new Thread(new GetKey(w, player2, 'o', 'l'));
		int dx = 4;
		int dy = 1;
		t1.start();
		t2.start();
		int p1Score = 0;
		int p2Score = 0;

		while (true) {
			ball.draw();
			player1.draw();
			player2.draw();

			// Player 1 Score
			w.moveTo(w.getWidth() / 2 - 20, 20);
			w.writeText(Integer.toString(p1Score));

			// Player 2 Score
			w.moveTo(w.getWidth() / 2 + 20, 20);
			w.writeText(Integer.toString(p2Score));

			ball.move(dx, dy);

			if (ball.getX() - 3 < player1.getX()
					&& ball.getX() + 3 > player1.getX()
					&& ball.getY() > player1.getY()
					&& ball.getY() < player1.getY() + 50) {
				dx = ball.playerHit(dx);

			} else if (ball.getX() - 3 < player2.getX()
					&& ball.getX() + 3 > player2.getX()
					&& ball.getY() > player2.getY()
					&& ball.getY() < player2.getY() + 50) {
				dx = ball.playerHit(dx);
			}
			dy = ball.changeYIfAtEnd(dy);
			
			//Player 2 wins
			if (ball.getX() < -10) {
				dx = ball.playerHit(dx);
				w.clear();
				p2Score++;
				
				w.moveTo(w.getWidth() / 2 + 20, 20);
				w.writeText(Integer.toString(p2Score));
				w.moveTo(w.getWidth() / 2 - 20, 20);
				w.writeText(Integer.toString(p1Score));
				player1.draw();
				player2.draw();
				
				ball.moveTo(w.getWidth() / 2, w.getHeight() / 2);
				SimpleWindow.delay(1000);
			} 
			//Player 1 wins
			else if (ball.getX() > w.getWidth() + 10) {
				dx = ball.playerHit(dx);
				w.clear();
				p1Score++;
				
				w.moveTo(w.getWidth() / 2 + 20, 20);
				w.writeText(Integer.toString(p2Score));
				w.moveTo(w.getWidth() / 2 - 20, 20);
				w.writeText(Integer.toString(p1Score));
				player1.draw();
				player2.draw();
				
				ball.moveTo(w.getWidth() / 2, w.getHeight() / 2);
				SimpleWindow.delay(1000);
			}

			SimpleWindow.delay(7);
			w.clear();

		}

	}

}
