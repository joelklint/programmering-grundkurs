package storaTal;

import java.math.BigInteger;
import java.util.Scanner;

public class StoraTal {
	public static void main(String[] args)	{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv in ett heltal");
		BigInteger sum = new BigInteger(String.valueOf(1));
		BigInteger ett = new BigInteger(String.valueOf(1));
		
		for (BigInteger n = new BigInteger(String.valueOf(scan.nextInt())); n.compareTo(ett) >= 0; n = n.subtract(ett) )	{
			sum = sum.multiply(n);
		}
		
		scan.close();
		System.out.println("Fakulteten av det tal du skrev in är " + sum);
	}

}
