import java.util.*;
//import IOManagment;

class Term {
	private String term;	// The term to be studied.
	private String def;		// The definition of the flashcard.
	private LinkedList<String> AcceptedDefs = new LinkedList<String>();
	private LinkedList<String> AcceptedTerms = new LinkedList<String>();
	private int[] accuracy;	// The accuracy in each phase. Updated every session.
	private Phase Phase;	// The current phase that the flashcard it in. Updated every session.
	private Scanner scnr = new Scanner(System.in);
	//public IOManagment input = new IOManagment();
	
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

	/**
	 * Reading Constructor
	 * @param fileInput A string containing the toString from the storage file.
	 */
	Term(String fileInput){
		// TODO:
		// ¡Hola mundo!*Hello world!<<*Hello world!*Hi world!*>>*<<¡Hola mundo!*¡Buenos días mundo!*>>
		
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

	public void addAcceptedDef(String newDef){
		AcceptedDefs.add(newDef);
	}

	public void addAcceptedTerm(String newTerm){
		AcceptedTerms.add(newTerm);
	}

	public void editAcceptedDefs() {
		System.out.printf("The current definitions are:");
		int i=1;
		for(String Accepted: AcceptedDefs){
			System.out.println("(" + i + ") " + Accepted);
			i++;
		}
		System.out.println("Which definition would you like to change?");
		int choice = scnr.nextInt();
		System.out.println("What would you like to set it to?");
		AcceptedDefs.set(choice, scnr.nextLine());
	}

	public void editAcceptedTerms() {
		System.out.printf("The current accepted terms are:");
		int i=1;
		for(String Accepted: AcceptedTerms){
			System.out.println("(" + i + ") " + Accepted);
			i++;
		}
		System.out.println("Which term would you like to change?");
		int choice = scnr.nextInt();
		System.out.println("What would you like to set it to?");
		AcceptedTerms.set(choice, scnr.nextLine());
	}

	public String toString(){
		String storage = "";
		storage += term + "*" + def + "<<*";
		for(String ADef : AcceptedDefs){
			storage += ADef + "*";
		}
		storage += ">>*<<";
		for(String ATerm : AcceptedTerms){
			storage += ATerm + "*";
		}
		storage += ">>";
		
		return storage;
	}
}

enum Phase{INTRO, DEF, TERM}
