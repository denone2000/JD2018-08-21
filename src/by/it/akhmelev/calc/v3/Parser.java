package by.it.akhmelev.calc.v3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {


    private Var calcOneOperation(String strOne, String strOperation, String strTwo) throws by.it.akhmelev.calc.v3.CalcException {
        //2+2    -2*2       2.0-2.22          -3/4.9
        //{2,7,8,6}+2    -2*2       2.0-2.22          -3/4.9
        Var two = Var.createVar(strTwo);
        if (strOperation.equals("=")) {
            Var.saveVar(strOne, two);
            return two;
        }
        Var one = Var.createVar(strOne);
        if (one == null || two == null) {
            //todo Create error unknow operation
            System.out.println("Переменная не распозана");
            return null;
        }

        switch (strOperation) {
            case "+":
                return one.add(two);
            case "-":
                return one.sub(two);
            case "*":
                return one.mul(two);
            case "/":
                return one.div(two);
        }

        //todo Create error unknow operation
        System.out.println("Операция не распозана");
        return null;
    }

    private final String[] priority = {"=", "+", "-", "*", "/"};

    private int currentOperationIndex(List<String> operations) {
        int currentResult = -1;
        int currentPrior = -1;
        for (int i = 0; i < operations.size(); i++) {
            int pr = -1;
            String op = operations.get(i);
            for (int j = 0; j < priority.length; j++) {
                if (priority[j].equals(op)) {
                    pr = j;
                    break;
                }
            }
            if (currentPrior < pr) {
                currentPrior = pr;
                currentResult = i;
            }

        }
        return currentResult;
    }

    Var calc(String expression) throws by.it.akhmelev.calc.v3.CalcException {
        String[] tmp = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(tmp));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find())
            operations.add(matcher.group());
        while (operations.size() > 0) {
            int index = currentOperationIndex(operations);
            String op = operations.remove(index);
            String one = operands.remove(index);
            String two = operands.remove(index);
            Var var = calcOneOperation(one, op, two);
            operands.add(index, var.toString());
        }
        return Var.createVar(operands.get(0));
    }
}
