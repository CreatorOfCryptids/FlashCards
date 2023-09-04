import java.util.*;
//import IOManagment.java;

class Term {
	private String term;	// The term to be studied.
	private String def;		// The definition of the flashcard.
	private LinkedList<String> AcceptedDefs = new LinkedList<String>();
	private LinkedList<String> AcceptedTerms = new LinkedList<String>();
	private int[] accuracy;	// The accuracy in each phase. Updated every session.
	private Phase Phase;	// The current phase that the flashcard it in. Updated every session.
	private Scanner scnr = new Scanner(System.in);
	private String pronunciation; 	// Optional storage of pronunciation
	public IOManagment IO = new IOManagment();
	
	/**
	 * For testing
	 *
	public static void main(String[] args){
		Term term = new Term("¡Hola mundo!","Hello world!");
		term.addAcceptedDef("Hi world!");
		term.addAcceptedTerm("¡Buenos días mundo!");
		System.out.print(term.toString());
	}/**/

	/**
	 * New Term Constructor
	 * @param term The term to be studied.
	 * @param definition The definition.
	 */
	Term(String term, String definition){
		this.term = term;
		this.def = definition;
		accuracy = new int[]{0,0,0};
		Phase = Phase.INTRO;
		AcceptedDefs.add(definition);
		AcceptedTerms.add(term);
	}

	Term(String term, String definition, String pronunciation){
		this.term = term;
		this.def = definition;
		this.pronunciation = pronunciation;
		accuracy = new int[]{0,0,0};
		Phase = Phase.INTRO;
		AcceptedDefs.add(definition);
		AcceptedTerms.add(term);
	}

	/**
	 * Reading Constructor
	 * @param fileInput A string containing the toString from the storage file.
	 */
	Term(String fileInput){
		// TODO:
		// ¡Hola mundo!!*Hello world!!*<<*Hello world!!*Hi world!!*>>*<<¡Hola mundo!!*¡Buenos días mundo!!*>
		
		// Send it to the string reader for ease of reading
		StringReader read = new StringReader(fileInput);

		// Read the term
		while (!read.isDone() && read.peek() != '*'){
			if (read.peek() == '!')
				read.swallow(1);
			term += read.getChar();
		}

		// Read the definition
		while (!read.isDone() && read.peek() != '*'){
			if (read.peek() == '!')
				read.swallow(1);
			def += read.getChar();
		}
		// Read the pronunciation (check to see if null)
		while (!read.isDone() && read.peek() != '*'){
			if (read.peek() == '!')
				read.swallow(1);
			term += read.getChar();
		}
		// Read the accepted definitions

		// Read the accepted terms

	}

	/**
	 * The getTerm() accessor.
	 * @return term
	 */
	public String getTerm(){
		String retTerm = term;
		return retTerm;
	}

	/**
	 * The getDefinition() accessor.
	 * @return definition
	 */
	public String getDef(){
		String retDef = def;
		return retDef;
	}

	public String getPronunciation(){
		String retPronunciation = pronunciation;
		return retPronunciation;
	}

	/**
	 * The getAccuracy() accessor.
	 * @param level selected phase
	 * @return accuracy for the correct phase
	 */
	public int getAccuracy(Phase level){
		return accuracy[level.ordinal()];
	}
	
	/**
	 * The setTerm() mutator.
	 * @param newTerm
	 */
	public void setTerm(String newTerm){
		this.term = newTerm;
	}

	public void setPronunciation(String newPronunciation){
		this.pronunciation = newPronunciation;
	}

	/**
	 * The setDef() mutator.
	 * @param newDef
	 */
	public void setDef(String newDef){
		this.def = newDef;
		AcceptedDefs.set(1, newDef);
	}

	/**
	 * The setPhase() mutator
	 * @param phase
	 */
	public void setPhase(Phase phase){
		this.Phase = phase;
	}

	/**
	 * The addAcceptedDef() method.
	 * @param newDef The new acceptable definition responce.
	 */
	public void addAcceptedDef(String newDef){
		AcceptedDefs.add(newDef);
	}

	/**
	 * The addAcceptedTerm() method.
	 * @param newTerm The new acceptable term responce.
	 */
	public void addAcceptedTerm(String newTerm){
		AcceptedTerms.add(newTerm);
	}

	/**
	 * The editAcceptedDefs() method.
	 * Allows the user to edit an incorrect accepted deffinition entry.
	 */
	public void editAcceptedDefs(int choice, String newEntry) {
		if (choice == AcceptedDefs.size())
			AcceptedDefs.add(newEntry);
		else if(newEntry != null)
			AcceptedDefs.set(choice, newEntry);
		else
			AcceptedDefs.remove(choice);
	}

	/**
	 * The editAcceptedTerms() method.
	 * Allows the user to edit an incorrect accepted term entry.
	 */
	public void editAcceptedTerms(int choice, String newEntry) {
		if (choice == AcceptedTerms.size())
			AcceptedTerms.add(newEntry);
		else if(newEntry != null)
			AcceptedTerms.set(choice, newEntry);
		else
			AcceptedTerms.remove(choice);
	}

	/**
	 * The fileFormat() method.
	 * Makes a string that can be printed to the file system, and read by the reading constructor.
	 */
	public String fileFormat(){
		String storage = "";
		storage += IO.fileCleaner(term) + "*" + IO.fileCleaner(def) + "*"; 
		if (pronunciation !=null) 
			storage += IO.fileCleaner(pronunciation); 
		storage += "<<*";
		for(String ADef : AcceptedDefs)
			storage += IO.fileCleaner(ADef) + "*";
		storage += ">>*<<";
		for(String ATerm : AcceptedTerms){
			storage += IO.fileCleaner(ATerm) + "*";
		}
		storage += ">>";
		
		return storage;
	}

	/**
	 * The toString method
	 */
	public String toString(){
		String output = "Term:\n" + term + "\nDefinition:\n" + def + "Pronunciation:\n" + pronunciation + "\n";
		return output;
	}

	private class StringReader{
		private String readMe;
		private int index;

		StringReader(String readMe){
			this.readMe = readMe;
			index = 0;
		}

		/**
		* The peek() method.
		* @param i How far ahead the method looks.
		* @return The char i characters ahead of the index.
		* Looks “i” characters ahead and returns that character; doesn’t move the index.
		*/
		public char peek(int i){
			// Make sure the index is not beond the end of the string.
			if((index+i < readMe.length()))
				return readMe.charAt(index+i);
			else
				return ' ';
		}

		/**
		 * The peek() overloaded method.
		 * Yes, I am not ashamed to admit that I made a whole extra method to get out of typing one single extra letter. Judge me all you want, but it works.
		 * @return The next character
		 */
		public char peek(){
			// Make sure the index is not beond the end of the string.
			if((index < readMe.length()))
				return readMe.charAt(index);
			else
				return ' ';
		}

		/**
		* The peekString() method. 
		* @param i How far ahead the method will look.
		* @return A string of the i characters in the file after the current index.
		* Returns a string of the next “i” characters but doesn’t move the index
		*/
		public String peekString(int i){
			return readMe.substring(index, index+i);
		}

		/**
		 * The getChar() method.
		 * @return The next char
		 * Returns the next character and moves the index
		 */
		public char getChar(){
			char output = readMe.charAt(index);
			index++;
			return output;   
		}

		/**
		 * The swallow method.
		 * @param i How far the index moves
		 * Moves the index ahead “i” positions
		 */
		public void swallow(int i) throws ArrayIndexOutOfBoundsException{
			if (i >=0)
				index += i;
			else 
				throw new ArrayIndexOutOfBoundsException();
		}

		/**
		 * The isDone() method.
		 * @return True if the index is at the end of the document. False if not.
		 */
		public boolean isDone(){
			return (readMe.length() <= index);
		}

		/**
		 * The remainder() method.
		 * @return The rest of the input file as a single string.
		 */
		public String remainder() {
			return readMe.substring(index);
		}

		public String readNext(){
			String retVal = "";
			while (!this.isDone() && this.peek() != '*'){
				if (this.peek() == '!')
					this.swallow(1);
				retVal += this.getChar();
			}
			return retVal;
		}
	}
}



enum Phase{INTRO, DEF, TERM}
