package lab8_9;
import java.awt.Color;

import se.lth.cs.ptdc.images.ImageFilter;

/** IdentityFilter beskriver en identitetstransformation */
public class ContrastFilter extends ImageFilter {
	/** skapa ett filterobjekt med namnet name */
	public ContrastFilter(String name) {
		super(name);
	}
	
	/** filtrera bilden i matrisen inPixels och returnera resultatet i
		en ny matris. Utnyttja eventuellt v??rdet av parameter */
	public Color[][] apply(Color[][] inPixels, double paramValue) {
		int height = inPixels.length;
		int width = inPixels[0].length;
		
		//ber??knar intensiteterna hos individuella pixlar
		short[][] intensity = computeIntensity(inPixels);
		
		//Ber??knar bildens intensitetshistogram
		int[] histogram = new int[256];
		for(int i = 0; i<height; i++)	{
			for(int j = 0; j<width; j++)	{
				int intens = intensity[i][j];
				histogram[intens]++;
			}
		}
		
		//Ber??knar cutOff
		int cutOff = (int)Math.round(paramValue/100*width*height);
		
		//Ber??knar lowCut
		int lowCut = 0;
		for(int i = 0, sum = 0; sum<cutOff; i++)	{
			sum = sum + histogram[i];
			lowCut = i;
		}
		
		//Ber??knar highCut
		int highCut = 0;
		for(int i = histogram.length-1, sum = 0; sum<cutOff; i--)	{
			sum = sum + histogram[i];
			highCut = i;
		}
		
		//Skapar nya pixlar
		Color[][] outPixels = new Color[height][width];
		for (int i = 0; i < height; ++i) {
			for (int j = 0; j < width; ++j) {
				if(cutOff == 0)	{
					int old = intensity[i][j];
					outPixels[i][j] = new Color(old, old, old);
				}				
				else if(intensity[i][j] <= lowCut)	{
					outPixels[i][j] = new Color(0, 0, 0);
				}
				else if(intensity[i][j] >= highCut)	{
					outPixels[i][j] = new Color(255, 255, 255);
				}
				else	{
					if(highCut==lowCut)	{
						lowCut++;
					}
					int newIntensity = 255 * (intensity[i][j] - lowCut) / (highCut - lowCut);
					outPixels[i][j] = new Color(newIntensity, newIntensity, newIntensity);
				}
			}
		}
		return outPixels;
	}
}
