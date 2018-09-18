package by.it.nesterovich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {
        String[] stringVars = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(stringVars[0]);
        Var two = Var.createVar(stringVars[1]);
        if (one == null || two == null) {
            System.out.println("нет переменной");
            return null; //TODO create error
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
        }
        //TODO create error
        return null;
    }
}
