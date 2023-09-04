import org.junit.Assert;
import org.junit.Test;
//import org.junit.Assert.*;

import junit.*;;
public class UnitTests {
    @Test
    public void Term_term(){
        Term test = new Term("¡Hola, mundo!", "Hello, world", "o'la,mun'do,");
        Assert.assertEquals("¡Hola, mundo!", test.getTerm());
        test.setTerm("\u00A1Adios, Marte!");
        Assert.assertEquals("\u00A1Adios, Marte!", test.getTerm());
    }

    @Test
    public void Term_def(){
        Term test = new Term("¡Hola, mundo!", "Hello, world", "o'la,mun'do,");
        Assert.assertEquals("Hello, world", test.getDef());
        test.setDef("Goodbye, Mars!");
        Assert.assertEquals("Goodbye, Mars!", test.getDef());
    }

    @Test
    public void Term_pronunciation(){

    }

    @Test
    public void Term_(){

    }

    @Test
    public void Term_fileFormat(){

    }

    //@Test
    //public void Term_term(){}

    
}
