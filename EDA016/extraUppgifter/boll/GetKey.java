package boll;

import se.lth.cs.window.SimpleWindow;

public class GetKey implements Runnable {
	private SimpleWindow w;
	private PongPlayer player;
	private char upp;
	private char ner;

	public GetKey(SimpleWindow w, PongPlayer player, char upp, char ner) {
		this.w = w;
		this.player = player;
		this.upp = upp;
		this.ner = ner;

	}

	public void run() {
		try {

			while (true) {
				w.waitForEvent();

				if (w.getKey() == upp) {
					if (player.getY()+10 > 0) {
						player.moveUp();
						SimpleWindow.delay(10);
					}
				} else if (w.getKey() == ner) {
					if (player.getY() + 50 < w.getHeight()) {
						player.moveDown();
						SimpleWindow.delay(10);
					}
				}
			}
		} catch (Exception e) {

		}
	}
}
