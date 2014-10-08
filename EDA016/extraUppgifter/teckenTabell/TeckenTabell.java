package teckenTabell;

import se.lth.cs.window.SimpleWindow;

public class TeckenTabell {
	public static void main(String[] args)	{
		
		SimpleWindow w = new SimpleWindow(300, 600, "Unicode Tabell");
		w.moveTo(0 + (w.getWidth()/12), 0 + (w.getHeight()/12));
		
		int dx = w.getWidth()/12;
		int dy = w.getHeight()/24;
		
		for(int i = 32; i<256; i++)	{
			char c = (char)i;
//			System.out.println(c);
			w.writeText(Character.toString(c));
			w.moveTo(w.getX(), w.getY() + dy);
			if(w.getY() > 11*w.getHeight()/12)	{
				w.moveTo(w.getX() + dx, dx * 2);
			}
			
		}

	}

}
