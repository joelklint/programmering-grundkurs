package mandelBrot;

import se.lth.cs.ptdc.fractal.MandelbrotGUI;


public class Mandelbrot {
	public static void main(String[] args) {
		
		MandelbrotGUI gui = new MandelbrotGUI();
		Generator gen = new Generator();
		boolean rendered = false;

		while (true) {
			switch (gui.getCommand()) {
			case MandelbrotGUI.QUIT:
				System.exit(0);
				break;
			case MandelbrotGUI.RESET:
				gui.resetPlane();
				gui.clearPlane();
				rendered = false;
				break;
			case MandelbrotGUI.RENDER:
				gen.render(gui);
				rendered = true;
				break;
			case MandelbrotGUI.ZOOM:
				if(rendered)	{
					gen.render(gui);
				}
				break;
			}

		}

	}

}