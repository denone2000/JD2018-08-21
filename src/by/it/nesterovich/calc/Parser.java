package by.it.nesterovich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression)  throws CalcException{
        if (expression.trim().equals("printvar")){
            Var.printVar();
            return null;
        }
        if (expression.trim().equals("sortvar")){
            Var.sortVar();
            return null;
        }
        String[] stringVars = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(stringVars[1]);
        if (expression.contains("=")){
            Var.saveVar(stringVars[0],two);
           // Var.saveVar(stringVars[0],two);
        }
        Var one = Var.createVar(stringVars[0]);
        if (one == null || two == null) {
            throw  new  CalcException("нет переменной");
           // System.out.println("нет переменной");
            //return null; //ODO create error
        }
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
        Matcher m = patternOperation.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
            //throw  new  CalcException("Невозможно определить операцию");
        }
        //ODO create error
        return null;
    }
}
