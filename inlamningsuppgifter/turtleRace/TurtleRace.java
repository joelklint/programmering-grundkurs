package turtleRace;

import lab4.Turtle;
import se.lth.cs.window.SimpleWindow;


public class TurtleRace {
	public static void main(String[] args) {

		SimpleWindow w = new SimpleWindow(600, 600, "Turtle Race");
		RaceTrack track = new RaceTrack(500, 100);
		Turtle t1 = new Turtle(w, 200, track.getStart());
		Turtle t2 = new Turtle(w, 400, track.getStart());
		t1.penDown();
		t2.penDown();
		track.draw(w);
		RacingEvent race = new RacingEvent(track, t1, t2);

		w.waitForMouseClick();
		race.start();
	}
}
