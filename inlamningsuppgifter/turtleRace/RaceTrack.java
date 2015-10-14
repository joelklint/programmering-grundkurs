package turtleRace;

import se.lth.cs.window.SimpleWindow;


public class RaceTrack {
	private int yStart;
	private int yFinish;

	public RaceTrack(int yStart, int yFinish) {
		this.yStart = yStart;
		this.yFinish = yFinish;
	}

	public void draw(SimpleWindow w) {
		w.moveTo(100, yStart);
		w.lineTo(500, yStart);
		w.moveTo(100, yFinish);
		w.lineTo(500, yFinish);
	}

	public int getStart() {
		return yStart;
	}

	public int getFinish() {
		return yFinish;
	}

}
