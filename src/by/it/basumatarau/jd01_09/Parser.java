package by.it.basumatarau.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calc(String str) {

        Pattern operatorPattern = Pattern.compile(RegExPatterns.OPERATOR);
        Matcher operatorMatcher = operatorPattern.matcher(str);
        String[] operands = str.split(RegExPatterns.OPERATOR);

        if (operands==null&&operands.length!=2) {
            System.out.println("invalid amount of operands has been parsed");
            return null;
        }

        Var varLeft = Var.createVar(operands[0]);
        Var varRight = Var.createVar(operands[1]);

        if(operatorMatcher.find()) {
            String operator = operatorMatcher.group();
            switch (operator) {
                case "+":
                    return varLeft.add(varRight);
                case "-":
                    return varLeft.sub(varRight);
                case "*":
                    return varLeft.mul(varRight);
                case "/":
                    return varLeft.div(varRight);
                default:
                    System.out.println("something went wrong...");
                    return null;
            }
        }
        System.out.println("operation type has not been parsed...");
        return null;
    }
}
