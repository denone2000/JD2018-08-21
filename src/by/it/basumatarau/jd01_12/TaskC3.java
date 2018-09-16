package by.it.basumatarau.jd01_12;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//to be finalized...
public class TaskC3 {
    public static void main(String[] args) {
        String testLineFix = "(2+3)+([3*4]+4)";
        String testLineFailed = "(2+3)+[(3*4]+4) (";

        parenthOrderChecker(testLineFix);
        parenthOrderChecker(testLineFailed);
    }
    static boolean parenthOrderChecker(String line){
        Stack<String> symbStack = new Stack<>();

        String parenthesisPattern = "[\\{\\}\\(\\)\\[\\]]";
        Pattern pattern = Pattern.compile(parenthesisPattern);
        Matcher parMatcher = pattern.matcher(line);

        while(parMatcher.find()){
            symbStack.push(parMatcher.group());
        }

        System.out.println(symbStack);
        return true;
    }
}
