package by.it.galushka.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private Var calcOneOperation(String firstOperand, String operation, String secondOperand) throws CalcException {
        Var var2 = Var.createVar(secondOperand);
        if (operation.equals("=")) {
            Var.saveVar(firstOperand, var2);
            return var2;
        }
        Var var1 = Var.createVar(firstOperand);
        if (var1 == null || var1 == null) {
            return null;
        }
        switch (operation) {
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

    private static Map<Integer, String> putPriority() {
        Map<Integer, String> priority = new HashMap<>();
        priority.put(0, "=");
        priority.put(1, "+");
        priority.put(2, "-");
        priority.put(3, "*");
        priority.put(4, "/");
        return priority;
    }

    Var calc(String expression) throws CalcException {
        String[] tmp = expression.split(Patterns.OPERATORS);
        List<String> operands = new ArrayList<>(Arrays.asList(tmp));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATORS).matcher(expression);
        while (matcher.find())
            operations.add(matcher.group());
        while (operands.size() > 1) {
            int indexPriorityOperation = priorityForCalc(operations);
            String one = operands.remove(indexPriorityOperation);
            String operation = operations.remove(indexPriorityOperation);
            String two = operands.remove(indexPriorityOperation);
            Var resultOneOperation = calcOneOperation(one, operation, two);
            operands.add(indexPriorityOperation, resultOneOperation.toString());
        }
        return Var.createVar(operands.get(0));
    }

    private int priorityForCalc(List<String> operations) {
        Map<Integer, String> priority = putPriority();
        int higherPriorityIndex = -1;
        int indexHighPriorValue = -1;
        for (Map.Entry<Integer, String> entry : priority.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            for (int j = 0; j < operations.size(); j++) {
                int actualPrioroty = -1;
                if (value.equals(operations.get(j))) {
                    actualPrioroty = key;
                    if (actualPrioroty > higherPriorityIndex) {
                        higherPriorityIndex = actualPrioroty;
                        indexHighPriorValue = j;
                    }
                }
            }
        }
        return indexHighPriorValue;
    }
}
