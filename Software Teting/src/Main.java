import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		IDAstar s = new IDAstar();
		double it = s.solve(new Board(sc.nextLine()), new Board(sc.nextLine()));
		System.out.println((int) it);
		sc.close();
		

	}
}

	
	