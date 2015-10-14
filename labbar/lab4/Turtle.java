package lab4;

import se.lth.cs.window.SimpleWindow;

public class Turtle {
	private double x = 0;
	private double y = 0;
	private boolean penDown = false;
	private double direction = Math.toRadians(90);
	protected SimpleWindow w;
	
	/**
	 * Skapar en sköldpadda som ritar i ritfönstret w. Från början befinner sig
	 * sköldpaddan i punkten x,y med pennan lyft och huvudet pekande rakt uppåt
	 * i fönstret (i negativ y-riktning)
	 */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		w.moveTo(x, y);
		this.x = w.getX();
		this.y = w.getY();
	}
	
	/** Sänker pennan */
	public void penDown() {
		penDown = true;
	}
	
	/** Lyfter pennan */
	public void penUp() {
		penDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning som huvudet pekar */
	public void forward(int n) {
		double newX = (x+Math.round(n*Math.cos(direction)));
		double newY = (y-Math.round(n*Math.sin(direction)));
		if(penDown == true)	{
			w.moveTo((int)x, (int)y);
			w.lineTo((int)newX, (int)newY);
		}
		else{
			w.moveTo((int)x, (int)y);
			w.moveTo((int)newX, (int)newY);
		}
		x = newX;
		y = newY;
	}
	
	/** Vrider beta grader åt vänster runt pennan */
	public void left(int beta) {
		direction = direction + Math.toRadians(beta);
	}
	
	/** Går till punkten newX,newY utan att rita. Pennans läge (sänkt 
	    eller lyft) och huvudets riktning påverkas inte */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	/** Återställer huvudriktningen till den ursprungliga */
	public void turnNorth() {
		direction = Math.toRadians(90);
	}
	
	/** Tar reda på x-koordinaten för sköldpaddans aktuella position */
	public int getX() {
		return (int)Math.round(x);
	}
	
	/** Tar reda på y-koordinaten för sköldpaddans aktuella position */
	public int getY() {
		return (int)Math.round(y);
	}
	
	/** Tar reda på sköldpaddans riktning, i grader från positiv x-led */
	public int getDirection() {
		return (int)Math.round(Math.toDegrees(direction));
	}
}
