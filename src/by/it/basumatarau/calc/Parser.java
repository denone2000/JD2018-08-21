package by.it.basumatarau.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public Var calc(String str) throws CalcException{

        Pattern operatorPattern = Pattern.compile(RegExPatterns.OPERATOR);
        Matcher operatorMatcher = operatorPattern.matcher(str);
        String[] operands = str.split(RegExPatterns.OPERATOR);

        if (operands.length != 2) {
            System.out.println("invalid amount of operands has been parsed");
            return null;
        }

        Var varRight = Var.createVar(operands[1].trim());
        if(str.contains("=")){
            return Var.saveVar(operands[0].trim(), varRight);
        }
        Var varLeft = Var.createVar(operands[0].trim());

        if (operatorMatcher.find()&&varLeft!=null&&varRight!=null) {
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
                    System.out.println("operation has not been described");
                    return null;
            }
        }
        System.out.println("operation type or one of the operands has not been parsed...");
        return null;

    }
}
