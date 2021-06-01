package pt.agendacontactos;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner readChoice = new Scanner(System.in);
		String res = readChoice.next();
		
		System.out.println(res);
		
		
		readChoice.hasNext();
		
		readChoice.close();
		
		System.out.println("Bye");

	}

}
