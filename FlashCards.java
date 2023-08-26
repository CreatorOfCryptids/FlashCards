import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.*;

public class FlashCards {
	
	Scanner scnr = new Scanner(System.in);

	public LinkedList<Language> languages = new LinkedList<Language>();
	
	public static void main(String[] args) {
		FlashCards fc = new FlashCards();
		//fc.languages = readFile();

		System.out.println("Which language would you like to study?")
		for(int i = 0; i<fc.languages.size(); i++){
			System.out.println("(" + (i+1) + ") " + fc.languages.get(i).toString());
		}


		System.out.printf("Which language are you learning today?\n");
			
	}
	
	private LinkedList<Language> readFile(){
		LinkedList<Language> languages = new LinkedList<Language>();
	}
}