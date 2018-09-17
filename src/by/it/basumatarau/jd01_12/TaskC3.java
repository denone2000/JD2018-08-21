package by.it.basumatarau.jd01_12;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        String testLineFix = "{((2+3)+([3*4]+4))}";
        String testLineFix2 = "{3}*({2}*([1]-2+3)+([3*4]+4))";
        String testLineFailed = "{3}*({2}*[1-2+3))";

        System.out.println(parenthOrderChecker(testLineFix)+ testLineFix);
        System.out.println(parenthOrderChecker(testLineFix2)+ testLineFix2);
        System.out.println(parenthOrderChecker(testLineFailed)+ testLineFailed);
    }
    private static boolean parenthOrderChecker(String line){
        Stack<String> separatorStack = new Stack<>();

        //noinspection RegExpRedundantEscape built-in regex chek doesn't work correctly...
        String separatorPattern = "[\\{\\}\\(\\)\\[\\]]";
        Pattern pattern = Pattern.compile(separatorPattern);
        Matcher parMatcher = pattern.matcher(line);

        String buffer;
        String token;
        while(parMatcher.find()){
            token=parMatcher.group();
            if((token).matches("[({\\[]")){
                separatorStack.push(token);
            }else if(token.matches("[)}\\]]")){
                buffer = token;
                //noinspection LoopStatementThatDoesntLoop the loop statement will be likely necessary for further work with the code (no latency footprint is anticipated)
                while(!((token=separatorStack.pop()).contains("[({\\[]"))){
                    if(!token.concat(buffer).matches("(\\[])|(\\{})|(\\(\\))")){
                        return false;
                    }else break;
                }
            }
        }
        return separatorStack.size()==0;
    }
}
