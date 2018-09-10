package by.it.galushka.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) {
        String[] divToExp = expression.split(Patterns.OPERATORS);
        Var var1 = Var.createVar(divToExp[0]);
        Var var2 = Var.createVar(divToExp[1]);
        if (var1==null || var1==null) {
            return null;
        }
        Pattern operator = Pattern.compile(Patterns.OPERATORS);
        Matcher matcher = operator.matcher(expression);
        if (matcher.find()) {
            switch (matcher.group()) {
                case "+":
                    return var1.add(var2);
                case "-":
                    return var1.sub(var2);
                case "*":
                    return var1.mul(var2);
                case "/":
                    return var1.div(var2);
                    default:
                        System.out.println("Ошибка!");
                        return null;
            }
        }
        return null;
    }
}
