package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.CalcException;
import by.it.korzik.jd02.jd02_04.Patterns;
import by.it.korzik.jd02.jd02_04.PriorityMap;
import by.it.korzik.jd02.jd02_04.Var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    private  List<String> operations = new ArrayList<>();

    Var calcOneOperation(String one, String operation, String two) throws CalcException {
        if (operation.equals("=")) {
            Var.saveVar(one, Var.createVar(two));
            return Var.createVar(two);
        }
        Var varOne = Var.createVar(one);
        Var varTwo = Var.createVar(two);
        if (varOne != null && varTwo != null) {
            switch (operation) {
                case "+":
                    return varOne.add(varTwo);
                case "-":
                    return varOne.sub(varTwo);
                case "*":
                    return varOne.mul(varTwo);
                case "/":
                    return varOne.div(varTwo);
            }
        }
        return null;
    }

    Var calc(String expression) throws CalcException {
        String[] operand = expression.split(Patterns.operation);
        List<String> strOperands = new ArrayList<>(Arrays.asList(operand));
        Pattern pattern = Pattern.compile(Patterns.operation);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size()>0){
        int index = PriorityMap.chooseoperation(operations);
        strOperands.add(index,calcOneOperation(strOperands.remove(index),operations.remove(index), strOperands.remove(index)).toString());}
    return Var.createVar(strOperands.get(0));
    }
}
