import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

//In this project, your task is to create a Java program that processes the provided
//"Hamlet" text file using regular expressions. The goal is to replace every
//occurrence of "Hamlet" with "Leon" and every occurrence of "Horatio" with "Tariq."
//**This process should be achieved exclusively using the Pattern and Matcher classes,
//without relying on String Utilities for direct word replacement.**
//Pattern p = Pattern.compile("a*b");
//    Matcher m = p.matcher("aaaaab");
//    boolean b = m.matches();

    @Test
    public void testChangeHamletToLeon() {
        String ham = "HAMLET Ay, madam, it is common.";
        String expected = "LEON Ay, madam, it is common.";
        String actual = HamletParser.replaceText(ham);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHamletToLeonCamelCase() {
        String ham = "Hamlet Ay, madam, it is common.";
        String expected = "Leon Ay, madam, it is common.";
        String actual = HamletParser.replaceText(ham);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        String ham = "HORATIO Ay, madam, it is common.";
        String expected = "TARIQ Ay, madam, it is common.";
        String actual = HamletParser.replaceText(ham);
        assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariqCamel() {
        String ham = "Horatio Ay, madam, it is common.";
        String expected = "Tariq Ay, madam, it is common.";
        String actual = HamletParser.replaceText(ham);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //given
        String regex = "HORATIO";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(hamletText);
        if (matcher.find()) {
            // Extract the matching word
            String word = matcher.group();

            // Then
            assertEquals(regex, word);
        } else {
            fail("No match found for the word 'HORATIO'");
        }
    }

    @Test
    public void testFindHamlet() {
        //given
        String regex = "HAMLET";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(hamletText);
        if (matcher.find()) {
            // Extract the matching word
            String word = matcher.group();

            // Then
            assertEquals(regex, word);
        } else {
            fail("No match found for the word 'HAMLET'");
        }
    }
}