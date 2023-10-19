import java.util.LinkedList;

abstract class Card extends Node{
    public enum Phase{ CHOICE, TERM, DEF}

    private LinkedList<String> terms;
    private LinkedList<String> definitions;
    private byte accuracy;
    private Phase phase;

    abstract boolean testCardP();
    abstract boolean testCardA();

    public String getTerm(){
        return terms.get(0);
    }

    public String getDef(){
        return definitions.get(0);
    }

    public String getAccuracy(){

    }
}
