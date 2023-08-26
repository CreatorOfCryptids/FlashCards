import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.*;
public class VocabMemorization {
	
	Scanner scnr = new Scanner(System.in);
	
	/*public static void main(String[] args) {
		VocabMemorization vm = new VocabMemorization();
		System.out.printf("Which language are you learning today?\n"
				+ "(1) Esperanto\n"
				+ "(2) German\n"
				+ "(3) Japanese\n"
				+ "(4) Spanish\n"
				+ "Selection: ");
		int choice = vm.getIntInput(1, 4);
		if (choice == 1) {
			var lines = Files.readAllLines(Paths.get("EsperantoTerms.txt"));
			
		}
		if (choice == 2) {
			var lines = Files.readAllLines(Paths.get("GermanTerms.txt"));

		}
		if (choice == 3) {
			var lines = Files.readAllLines(Paths.get("JapaneseTerms.txt"));

		}
		if (choice == 4) {
			var lines = Files.readAllLines(Paths.get("SpanishTerms.txt"));

		}
	}*/
	
	/**
	 * The getIntInput() method.
	 * @param min Smallest valid input
	 * @param max Largest valid input
	 * @return
	 */
	private int getIntInput(int min, int max) {
		try {
			String input =  scnr.nextLine();
			// Check for quit condition.
			if (input.contains("q") || input.contains("Q")) {// Make sure they want to quit.
				System.out.printf("Are you sure you want to quit? You will lose any values that you have entered.\n"
						+ "Type 'Y' if you want to quit, or enter another number to continue.\n"
						+ "Selection: ");
				input = scnr.nextLine();
				if (input.equalsIgnoreCase("Y")) {
					return -1;
				}
			}
			// Check for valid integer input.
			
			int intInput = Integer.parseInt(input);
			if (intInput >= min && intInput <=max) { 
				return intInput;
			}
			// If invalid input, get correct input.
			System.out.printf("The number you've selected is invalid. Please type a number between " + min + " and " + max + ".\n"
					+ "New selecion: ");
			return getIntInput(min, max);
		}
		// If invalid input, get correct input.
		catch (java.lang.NumberFormatException e) {
			System.out.printf("The number you've selected is invalid. Please type a number between " + min + " and " + max + ".\n"
				+ "New selecion: ");
			return getIntInput(min, max);
		}
	}
}