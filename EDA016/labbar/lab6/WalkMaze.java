package lab6;

import java.util.Scanner;

import se.lth.cs.ptdc.maze.Maze;
import se.lth.cs.window.SimpleWindow;

public class WalkMaze {
	public static void main(String[] args)	{
		
		SimpleWindow w = new SimpleWindow(500, 500, "The Maze");
		Scanner scan = new Scanner(System.in);
		System.out.println("Välj en labyrint mellan 1 - 5");
		int MazeNbr = scan.nextInt();
		scan.close();
		
		Maze m = new Maze(MazeNbr);
		m.draw(w);
		MazeTurtle mt = new MazeTurtle(w, 5, 5);
		mt.walk(m);
		
		
	}

}
