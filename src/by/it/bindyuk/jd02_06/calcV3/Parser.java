package by.it.bindyuk.jd02_06.calcV3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final List<String> priority = new ArrayList<>(Arrays.asList("=,+,-,*,/".split(",")));

    private Var oneOperationCalc(String s1, String oper, String s2) throws CalcException {

        Var two = VarSelector.getVar(s2);//Var.createVar(s2);
        if (oper.equals("=")) {
            Var.saveVars(s1, two);
            return two;
        }
        Var one = VarSelector.getVar(s1);//Var.createVar(s1);
        if (one == null || two == null) {
            ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                    (Messages.MSG_UNKNOWN_VARIABLE));
            throw new CalcException(ConsoleRunner.res.getKeys
                    (Messages.MSG_UNKNOWN_VARIABLE));
        }
        switch (oper) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }
        return null;
    }

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
            Var var = oneOperationCalc(v1, op, v2);
            assert var != null;
            operands.add(index, var.toString());
        }
        return VarSelector.getVar(operands.get(0));//Var.createVar(operands.get(0));
    }
}