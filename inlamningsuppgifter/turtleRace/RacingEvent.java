package turtleRace;

import java.util.Random;

import lab4.Turtle;
import se.lth.cs.window.SimpleWindow;

public class RacingEvent {

	private Turtle t1;
	private Turtle t2;
	private RaceTrack track;
	private Random rand = new Random();

	public RacingEvent(RaceTrack track, Turtle t1, Turtle t2) {
		this.t1 = t1;
		this.t2 = t2;
		this.track = track;
	}

	public void start() {
		while (track.getFinish() < t1.getY() && track.getFinish() < t2.getY()) {
			SimpleWindow.delay(3);
			t1.forward(rand.nextInt(3));
			SimpleWindow.delay(3);
			t2.forward(rand.nextInt(3));
		}
		if (t1.getY() < t2.getY()) {
			System.out.println("Player 1 vann!");
		} else if (t2.getY() < t1.getY()) {
			System.out.println("Player 2 vann!");
		} else {
			System.out.println("Det blev oavgjort!");
		}

	}
}
