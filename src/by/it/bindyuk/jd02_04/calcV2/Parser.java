package by.it.bindyuk.jd02_04.calcV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private Var oneOperationCalc(String v1, String op, String v2) throws CalcException {

        Var two = Var.createVar(v2);
        if (op.equals("=")) {
            Var.saveVars(v1, two);
            return two;
        }
        Var one = Var.createVar(v1);
        switch (op) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        if (one == null || two == null) {
            throw new CalcException("Неизвестное значение одной из переменной");
        }
        return null;
    }

    private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));

    private int getPosOperation(List<String> operations) {
        int currentResult = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            int prior = -1;
            String op = operations.get(i);
            for (int j = 0; j < priority.size(); j++) {
                if (priority.get(j).equals(op)) {
                    prior = j;
                    break;
                }
            }
            if (currentPriority < prior) {
                currentPriority = prior;
                currentResult = i;
            }
        }
        return currentResult;
    }

    Var calc(String expression) throws CalcException {
        String[] strVars = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(strVars));

        List<String> operations = new ArrayList<>();

        Pattern operationPattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcherFinder = operationPattern.matcher(expression);
        while (matcherFinder.find()) {
            operations.add(matcherFinder.group());
        }

        while (operations.size() > 0) {
            int index = getPosOperation(operations);
            String op = operations.remove(index);
            String v1 = operands.remove(index);
            String v2 = operands.remove(index);
            Var var = oneOperationCalc(v1,op,v2);
            assert var != null;
            operands.add(index,var.toString());
        }
        return Var.createVar(operands.get(0));
    }
}