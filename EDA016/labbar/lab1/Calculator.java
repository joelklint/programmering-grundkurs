package lab1;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		double sum = nbr1 + nbr2;
		double skil = nbr2 - nbr1;
		double prod = nbr1*nbr2;
		double kvot = nbr1/nbr2;
		System.out.println("Summan av talen är " + sum);
		System.out.println("Skillnaden mellan talen är " + skil);
		System.out.println("Produkten av talen är " + prod);
		System.out.println("Kvoten mellan talen är " + kvot);
		scan.close();
	}
}
