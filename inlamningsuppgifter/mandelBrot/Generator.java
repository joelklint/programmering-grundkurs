package mandelBrot;

import java.awt.Color;
import java.util.Scanner;

import se.lth.cs.ptdc.fractal.MandelbrotGUI;

public class Generator {

	private int oldIterations = 200;
	private Color[] color;
	private Scanner scan;
	private boolean scanExist;

	public Generator() {
		color = new Color[201];
		for (int i = 0; i < 200; i++) {
			color[i] = Color.getHSBColor((i * ((float) 100 / 250)) / 30,
					(float) 0.8, (float) 0.8);
		}

	}
	
	public void render(MandelbrotGUI GUI) {
		GUI.disableInput();

		int iterations = 200;
		if (!(scanExist)) {
			scan = new Scanner(GUI.getExtraText());
		}
		if (scan.hasNextInt()) {
			iterations = scan.nextInt();
		}

		int res;
		switch (GUI.getResolution()) {
		case MandelbrotGUI.RESOLUTION_VERY_HIGH:
			res = 1;
			break;
		case MandelbrotGUI.RESOLUTION_HIGH:
			res = 3;
			break;
		case MandelbrotGUI.RESOLUTION_MEDIUM:
			res = 5;
			break;
		case MandelbrotGUI.RESOLUTION_LOW:
			res = 7;
			break;
		case MandelbrotGUI.RESOLUTION_VERY_LOW:
			res = 9;
			break;
		default:
			res = 1;
			break;
		}

		if (oldIterations != iterations) {
			color = new Color[iterations + 1];
			for (int i = 0; i < iterations; i++) {
				color[i] = Color.getHSBColor((i * ((float) 100 / 250)) / 30,
						(float) 0.8, (float) 0.8);
			}
		}

		Complex[][] complex = mesh(GUI.getMinimumReal(), GUI.getMaximumReal(),
				GUI.getMinimumImag(), GUI.getMaximumImag(), GUI.getWidth(),
				GUI.getHeight());
		Color[][] picture = new Color[GUI.getHeight() / res + 1][GUI.getWidth()
				/ res + 1];

		for (int i = 0; i < GUI.getHeight() / res; i++) {
			for (int j = 0; j < GUI.getWidth() / res; j++) {
				int a = res / 2 + i * res;
				int b = res / 2 + j * res;
				Complex z = new Complex(0, 0);
				Complex c = complex[a][b];

				int n = 0;
				while (n < iterations && z.getAbs2() <= 4) {
					n++;
					z.mul(z);
					if (n != 0) {
						z.add(c);
					}
				}

				switch (GUI.getMode()) {
				case MandelbrotGUI.MODE_BW:

					if (z.getAbs2() <= 4) {
						picture[i][j] = Color.black;
					} else {
						picture[i][j] = Color.white;
					}

					break;
				case MandelbrotGUI.MODE_COLOR:

					if (z.getAbs2() <= 4) {
						picture[i][j] = Color.black;
					} else {
						picture[i][j] = color[n];
					}
					break;
				}
			}
		}
		GUI.putData(picture, res, res);
		GUI.enableInput();
		oldIterations = iterations;

	}
	
	private Complex[][] mesh(double minRe, double maxRe, double minIm,
			double maxIm, int width, int height) {
		Complex[][] complex = new Complex[height][width];

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				complex[i][j] = new Complex(minRe + (-minRe + maxRe)
						/(width - 1) * j, maxIm - (-minIm + maxIm)
						/(height - 1) * i);
			}
		}
		return complex;
	}

}