import java.util.*;
public class IOManagment {
    Scanner scnr = new Scanner(System.in);
    public int getInt(int lower, int upper){
        int retval;
        try{
            retval = scnr.nextInt();
        }
        catch(){
            
        }
    }

    public int getIntInput(int smallestInput, int largestInput) {
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
			if (intInput >= smallestInput && intInput <=largestInput) { 
				return intInput;
			}
			// If invalid input, get correct input.
			System.out.printf("The number you've selected is invalid. Please type a number between " + smallestInput + " and " + largestInput + ".\n"
					+ "New selecion: ");
			return getIntInput(smallestInput, largestInput);
		}
		// If invalid input, get correct input.
		catch (java.lang.NumberFormatException e) {
			System.out.printf("The number you've selected is invalid. Please type a number between " + smallestInput + " and " + largestInput + ".\n"
				+ "New selecion: ");
			return getIntInput(smallestInput, largestInput);
		}
		//return -1; 
	}
}
