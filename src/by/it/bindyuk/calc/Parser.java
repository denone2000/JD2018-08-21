package by.it.bindyuk.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException{
        String[] strVars = expression.split(Patterns.OPERATION);                //making array of Vars(till string)
        Var two = Var.createVar(strVars[1]);                                    //now Vars creating from string
               if(expression.contains("=")){
                  return Var.saveVars(strVars[0],two);
               }
        Var one = Var.createVar(strVars[0]);
        if(one == null || two == null) return null;
        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherFinder = operationPattern.matcher(expression);           //looking for operation
        if (matcherFinder.find()) {
            String operationFound = matcherFinder.group();               //if we're find operation, do and return this:
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