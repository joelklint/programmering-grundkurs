package boll;

import se.lth.cs.window.SimpleWindow;

public class PongPlayer {
	
	private SimpleWindow w;
	private int x, y, dy;
	
	
	public PongPlayer(SimpleWindow w, int xPos)	{
		this.w = w;
		this.x = xPos;
		y = w.getHeight()/2;
		dy = 30;
	}
	
	public void moveUp()	{
		y = y-dy;	
		draw();
	}
	
	public void draw()	{
		w.moveTo(x, y);
		w.lineTo(x, y+50);
	}
	
	public void moveDown()	{
		y = y+dy;
		draw();
	}
	
	public int getY()	{
		return y;
	}
	
	public int getX()	{
		return x;
	}

}
