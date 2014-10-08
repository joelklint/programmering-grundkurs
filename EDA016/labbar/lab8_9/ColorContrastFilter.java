package lab8_9;

import java.awt.Color;

import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ColorContrastFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public ColorContrastFilter(String name) {
		super(name);
	}

	/**
	 * filtrera bilden i matrisen inPixels och returnera resultatet i en ny
	 * matris. Utnyttja eventuellt värdet av parameter
	 */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;

		// beräknar intensiteterna hos individuella pixlars färger
		int[][] redIntensity = new int[height][width];
		int[][] greenIntensity = new int[height][width];
		int[][] blueIntensity = new int[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				redIntensity[i][j] = inPixels[i][j].getRed();
				greenIntensity[i][j] = inPixels[i][j].getGreen();
				blueIntensity[i][j] = inPixels[i][j].getBlue();
			}
		}

		// Beräknar bildens intensitetshistogram
		int[] redHistogram = new int[256];
		int[] greenHistogram = new int[256];
		int[] blueHistogram = new int[256];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int intens = redIntensity[i][j];
				redHistogram[intens]++;

				intens = greenIntensity[i][j];
				greenHistogram[intens]++;

				intens = blueIntensity[i][j];
				blueHistogram[intens]++;
			}
		}

		// Beräknar cutOff
		int cutOff = (int) Math.round(paramValue / 100 * width * height);

		// Beräknar lowCut
		int redLowCut = 0;
		int greenLowCut = 0;
		int blueLowCut = 0;
		boolean redDone = false;
		boolean greenDone = false;
		boolean blueDone = false;
		for (int i = 0, rSum = 0, gSum = 0, bSum = 0; true; i++) {
			rSum = rSum + redHistogram[i];
			gSum = gSum + greenHistogram[i];
			bSum = bSum + blueHistogram[i];

			if (rSum >= cutOff && !redDone) {
				redLowCut = i;
				redDone = true;
			}
			if (gSum >= cutOff && !greenDone) {
				greenLowCut = i;
				greenDone = true;
			}
			if(bSum >=cutOff && !blueDone)	{
				blueLowCut = i;
				blueDone = true;
			}
			if (redDone && greenDone && blueDone) {
				break;
			}
		}

		// Beräknar highCut
		int redHighCut = 0;
		int greenHighCut = 0;
		int blueHighCut = 0;
		redDone = false;
		greenDone = false;
		blueDone = false;
		for (int i = 255, rSum = 0, gSum = 0, bSum = 0; true; i--) {
			rSum = rSum + redHistogram[i];
			gSum = gSum + greenHistogram[i];
			bSum = bSum + blueHistogram[i];

			if (rSum >= cutOff && !redDone) {
				redHighCut = i;
				redDone = true;
			}
			if (gSum >= cutOff && !greenDone) {
				greenHighCut = i;
				greenDone = true;
			}
			if(bSum >=cutOff && !blueDone)	{
				blueHighCut = i;
				blueDone = true;
			}
			if (redDone && greenDone && blueDone) {
				break;
			}
		}

		// Skapar nya pixlar
		Color[][] outPixels = new Color[height][width];
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if (cutOff == 0) {
					int red = redIntensity[i][j];
					int green = greenIntensity[i][j];
					int blue = blueIntensity[i][j];
					outPixels[i][j] = new Color(red, green, blue);
				}
					
				else {
					if(redHighCut == redLowCut)	{
						redLowCut++;
					}
					int newRedIntensity = 255 * (redIntensity[i][j] - redLowCut)
							/ (redHighCut - redLowCut);
					
					if(greenHighCut == greenLowCut)	{
						greenLowCut++;
					}					
					int newGreenIntensity = 255 * (greenIntensity[i][j] - greenLowCut)
							/ (greenHighCut - greenLowCut);
					
					if(blueHighCut == blueLowCut)	{
						blueLowCut++;
					}
					int newBlueIntensity = 255 * (blueIntensity[i][j] - blueLowCut)
							/ (blueHighCut - blueLowCut);
					
					if(redIntensity[i][j] <= redLowCut)	{
						newRedIntensity = 0;
					}
					else if(redIntensity[i][j] >= redHighCut)	{
						newRedIntensity = 255;
					}
					
					if(greenIntensity[i][j] <= greenLowCut)	{
						newGreenIntensity = 0;
					}
					else if(greenIntensity[i][j] >= greenHighCut)	{
						newGreenIntensity = 255;
					}
					
					if(blueIntensity[i][j] <= blueLowCut)	{
						newBlueIntensity = 0;
					}
					else if(blueIntensity[i][j] >= blueHighCut)	{
						newBlueIntensity = 255;
					}
					outPixels[i][j] = new Color(newRedIntensity, newGreenIntensity,
							newBlueIntensity);
				}
			}
		}
		return outPixels;
	}
}