import org.junit.Assert;
import org.junit.Test;

public class UnitTests {
    @Test
    public void Term_term(){
        Term test = new Term("¡Hola, mundo!", "Hello, world", "o'la,mun'do,");
        Assert.assertEquals("¡Hola, mundo!", test.getTerm());
        Assert.assertEquals("¡Hola, mundo!", test.getAcceptedTerms()[0]);
        test.setTerm("\u00A1Adios, Marte!");
        Assert.assertEquals("\u00A1Adios, Marte!", test.getTerm());

    }

    @Test
    public void Term_def(){
        Term test = new Term("¡Hola, mundo!", "Hello, world", "o'la,mun'do,");
        Assert.assertEquals("Hello, world", test.getDef());
        Assert.assertEquals("Hello, world", test.getAcceptedDefs()[0]);
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
        Term test = new Term("¡Hola, mundo!", "Hello, world!", "o'la,mun'do,");
        test.addAcceptedDef("Hi world!");
        test.addAcceptedTerm("¡Buenos días mundo!");
        String expectedFileFormat = "¡Hola, mundo!!*Hello, world!!*o'la,mun'do,<<*Hello, world!!*Hi world!!*>>*<<¡Hola mundo!!*¡Buenos días mundo!!*>>";
        Assert.assertEquals(expectedFileFormat, test.fileFormat());
    }

    @Test
    public void Term_fileRead(){

    }

    @Test
    public void IO_fileCleaner(){
        IOManagment IO = new IOManagment();
        String test = "Hi! My # is $and<<> \\ *";
        String expected = "Hi!! My !# is !$and!<!<!> !\\ !*";
        Assert.assertEquals(expected, IO.fileCleaner(test));
    }
}
