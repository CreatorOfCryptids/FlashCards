import java.io.File;
import java.util.*;

public class IOManager {

    Scanner scnr;
	File database;
	Folder root;
	Folder current;

	IOManager(String fileName){
		scnr = new Scanner(System.in);
		database = new File(fileName);
	}

	public void readDataBase(){

	}
}
