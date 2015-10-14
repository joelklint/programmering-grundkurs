package boll;

import se.lth.cs.window.SimpleWindow;


public class Ball {

	private int side;
	private int x;
	private int y;
	protected SimpleWindow w;

	/** Skapar en boll */
	public Ball(SimpleWindow w, int side) {
		this.w = w;
		x = w.getWidth() / 2;
		y = w.getHeight() / 2;
		this.side = side;
	}

	/**
	 * Ritar bollen i ett SimpleWindow
	 * 
	 * @param w
	 *            Bestämmer vilket fönster
	 */
	public void draw() {
		w.moveTo((int) Math.round(x - side / 2), (int) Math.round(y));
		w.setLineWidth(side);
		w.lineTo((int) Math.round(x + side / 2), (int) Math.round(y));
	}

	/**
	 * Flyttar bollen relativt sin nuvarande position
	 * 
	 * @param x
	 *            förflyttning i x-led
	 * @param y
	 *            förflyttning i y-led
	 */
	public void move(int x, int y) {
		this.x = this.x + x;
		this.y = this.y + y;
	}

	/**
	 * Flyttar bollen till en bestämd position
	 * 
	 * @param x
	 *            Bollens önskade x-läge
	 * @param y
	 *            Bollens önskade y-läge
	 */
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		draw();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int changeXIfAtEnd(int dx) {
		if (x > w.getWidth() || x < 0) {
			int i = 0 - dx;
			return i;
		} else
			return dx;
	}

	public int changeYIfAtEnd(int dy) {
		if (y > w.getHeight() || y < 0) {
			int i = 0 - dy;
			return i;
		} else
			return dy;
	}

	public int playerHit(int dx) {
		int i = 0 - dx;
		return i;
	}
}
