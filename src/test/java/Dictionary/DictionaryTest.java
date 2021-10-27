package Dictionary;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class DictionaryTest{

    List<String> lista;
    DictionaryBuilder dbuilder;
    String jezyk;
    Set<String> setSlow;
    Dictionary testowy;

    @Before
    public void setUp()
    {
        System.out.println("Setup starts.");
        dbuilder = new DictionaryBuilder();
        lista = new ArrayList<>();
    }


    @Test
    public void Testfirst()
    {
        lista = Arrays.asList("dliji", "jhj", "drt");
        setSlow = new HashSet<>(lista);
        jezyk = "etr";
        testowy = dbuilder.language(jezyk).wordsList(setSlow).build();
        System.out.println(testowy.searchWord("dwdaw"));
    }

    @Test
    public void Testsecond()
    {
        lista = Arrays.asList("gfd", "dgf", "dwuytdaw");
        setSlow = new HashSet<>(lista);
        jezyk = "datdaw";
        testowy = dbuilder.language(jezyk).wordsList(setSlow).build();
        System.out.println(testowy.searchWord("ser"));
    }

    @Test
    public void Testthird()
    {
        lista = Arrays.asList("gfj", "gfhy", "et");
        setSlow = new HashSet<>(lista);
        jezyk = "sresf";
        testowy = dbuilder.language(jezyk).wordsList(setSlow).build();
        System.out.println(testowy.searchWord("gfj"));
    }


}