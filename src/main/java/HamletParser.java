import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public static String replaceText(String input){
        //HAMLET
        Pattern hamletPattern = Pattern.compile("HAMLET");
        Matcher hamletUppercaseMatcher = hamletPattern.matcher(input);
        //Hamlet
        Pattern hamletPatternCamel = Pattern.compile("Hamlet");
        Matcher hamletCamelMatcher = hamletPatternCamel.matcher(input);
        //HORATIO
        Pattern horatioPattern = Pattern.compile("HORATIO");
        Matcher horatioMatcher = horatioPattern.matcher(input);
        //Horatio
        Pattern horatioCamelPattern = Pattern.compile("Horatio");
        Matcher horatioCamelMatcher = horatioCamelPattern.matcher(input);
        if (hamletUppercaseMatcher.find()){
            input = hamletUppercaseMatcher.replaceAll("LEON");
        } else if (hamletCamelMatcher.find()){
            input = hamletCamelMatcher.replaceAll("Leon");
        }
        if (horatioMatcher.find()){
            input = horatioMatcher.replaceAll("TARIQ");
        } else if (horatioCamelMatcher.find()){
            input = horatioCamelMatcher.replaceAll("Tariq");
        }
        return input;
    }

    public static void main (String[] args){
        HamletParser ham = new HamletParser();
//        System.out.println(ham.getHamletData());
        String leonHam = replaceText(ham.getHamletData());
        System.out.println(leonHam);
    }
}
