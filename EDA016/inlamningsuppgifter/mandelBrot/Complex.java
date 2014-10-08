package mandelBrot;

public class Complex {
	
	private double re, im;
	
	/**Skapar ett komplext tal
	 * 
	 * @param re Realdelen av talet
	 * @param im Imaginärdelen av talet
	 */
	public Complex	(double re, double im)	{
		this.re = re;
		this.im = im;
	}
	
	/**Tar reda på den reela delen av det komplexa talet*/
	public double getRe()	{
		return re;
	}
	
	/**Tar reda på imaginärdelen av det komplexa talet*/
	public double getIm()	{
		return im;
	}
	
	/**Returnerar sträckan mellan origo och det kompleca talet i kvadrat*/
	public double getAbs2()	{
		return re*re+im*im;
	}
	
	/**Adderar ett komplext tal c till det aktuella komplexa talet
	 * 
	 * @param c Det komplexa talet som ska adderas 
	 */
	public void add(Complex c)	{
		re = re + c.getRe();
		im = im + c.getIm();
	}
	
	/**Multiplicerar ett komplext tal c med det aktuella komplexa talet
	 * 
	 * @param c Det komplexa talet som ska multipleceras 
	 */
	public void mul(Complex c)	{
		double tempRe = getRe() * c.getRe() - getIm() * c.getIm();
		double tempIm = getRe() * c.getIm() + getIm() * c.getRe();
		re = tempRe;
		im = tempIm;
	}

}