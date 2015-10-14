package lab8_9;
import se.lth.cs.ptdc.images.ImageFilter;
import se.lth.cs.ptdc.images.ImageGUI;

public class ImageProcessor {
	public static void main(String[] args) {
		ImageFilter[] filters = new ImageFilter[5];
//		filters[0] = new IdentityFilter("Identity Filter");
		filters[0] = new BlueFilter("Blue Filter");
		filters[1] = new InvertFilter("Invert Filter");
		filters[2] = new GrayScale("Gray Scale");
		filters[3] = new ContrastFilter("Contrast Filter");
		filters[4] = new ColorContrastFilter("Color Contrast Filter");
		new ImageGUI(filters);
	}
}
