package by.it.bindyuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) {
        String[] strVars = expression.split(Patterns.OPERATION);                //making array of Vars(till string)
        Var one = Var.createVar(strVars[0]);                                    //now Vars creating from string
        Var two = Var.createVar(strVars[1]);
        if(one == null || two == null) return null;
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherFinder = operationPattern.matcher(expression);           //looking for operation
        if (matcherFinder.find()) {
            String operationFound = matcherFinder.group();                      //if find operation, do and return this:
            switch (operationFound) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }
}