package lab10;

import java.util.ArrayList;

import se.lth.cs.window.SimpleWindow;

/**
 * Beskriver en lista av figurobjekt (objekt av klassen Shape).
 * OBSERVERA: bara skelett, du ska sj��lv skriva denna klass.
 */
public class ShapeList {
	
	private ArrayList<Shape> shapes;
	
	/**
	 * Skapar en tom lista.
	 */
	public ShapeList() {
		shapes = new ArrayList<Shape>();
	}

	/**
	 * L��gger in en figur i listan.
	 * 
	 * @param s
	 *            figuren som ska l��ggas in i listan
	 */
	public void insert(Shape s) {
		shapes.add(s);
	}

	/**
	 * Ritar upp figurerna i listan.
	 * 
	 * @param w
	 *            f��nstret d��r figurerna ritas
	 */
	public void draw(SimpleWindow w) {
		for(int i = 0; i<shapes.size(); i++)	{
			shapes.get(i).draw(w);
		}
	}

	/**
	 * Tar reda p�� en figur som ligger n��ra punkten xc,yc. Om flera figurer
	 * ligger n��ra s�� returneras den f��rsta som hittas, om ingen figur ligger
	 * n��ra returneras null.
	 * 
	 * @param xc
	 *            x-koordinaten
	 * @param yc
	 *            y-koordinaten
	 */
	public Shape findHit(int xc, int yc) {
		for(int i = 0; i<shapes.size(); i++)	{
			Shape s = shapes.get(i);
			if(s.near(xc, yc))	{
				return s;
			}
		}
		return null;
	}
	
	public Shape findShape(int xc, int yc) {
		for(int i = 0; i<shapes.size(); i++)	{
			Shape s = shapes.get(i);
			if(s.hasShapeAt(xc, yc))	{
				return s;
			}
		}
		return null;
	}
	
	public int size()	{
		return shapes.size();
	}
	
	public Shape get(int index) {
		return shapes.get(index);
	}
}
