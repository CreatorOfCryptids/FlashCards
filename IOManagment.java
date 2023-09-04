import java.util.*;

public class IOManagment {

    Scanner scnr = new Scanner(System.in);

	public void flashcard(){

	}

	public int multipleChoice(String message, String[] choices){
		System.out.println(message);
		for(int i=0; i<choices.length; i++){
			System.out.println("(" + (i+1) + ") " + choices[i]);
		}
		System.out.print("Selection: ");
		return getInt(1, choices.length);
	}

	public String textResponce(String message){
		System.out.println(message);
		return scnr.nextLine();
	}

	// TODO: Figure out why this isn't doing anything.
	public static String fileCleaner(String input){
		String retVal = input;
		retVal.replace("!", "!!");
		retVal.replace("#", "!#");
		retVal.replace("$", "!$");
		retVal.replace("*", "!*");
		retVal.replace("<", "!<");
		retVal.replace(">", "!>");
		retVal.replace("\\", "!\\");
		return retVal;
	}

	public static String fileUncleaner(String input){
		String retVal = input;
		retVal.replace("!!", "!");
		retVal.replace("!#", "#");
		retVal.replace("!$", "$");
		retVal.replace("!*", "*");
		retVal.replace("!<", "<");
		retVal.replace("!>", ">");
		retVal.replace("!\\", "\\");
		return retVal;
	}

    public int getInt(int lower, int upper){
		try {
			String input =  scnr.nextLine();
			// Check for valid integer input.
			int intInput = Integer.parseInt(input);
			if (intInput >= lower && intInput <=upper) { 
				return intInput;
			}
			// If invalid input, get correct input.
			System.out.printf("The number you've selected is invalid. Please type a number between " + lower + " and " + upper + ".\n"
					+ "New selecion: ");
			return getInt(lower, upper);
		}
		// If invalid input, get correct input.
		catch (java.lang.NumberFormatException e) {
			System.out.printf("The number you've selected is invalid. Please type a number between " + lower + " and " + upper + ".\n"
				+ "New selecion: ");
			return getInt(lower, upper);
		}
    }
}
