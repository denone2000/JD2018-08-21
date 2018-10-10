package by.it.nesterovich.jd02_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private final String[] priority = {"=", "+", "-", "*", "/"};

    private String expressionSimplification(String str) throws CalcException {
        Parser parser = new Parser();
        if (!str.contains("(") || !str.contains(")")) {
            return str;
        } else {
            Pattern patternExpressionsInBrackets = Pattern.compile("\\([^\\(\\)]+\\)");
            Matcher matcher = patternExpressionsInBrackets.matcher(str);
            if (matcher.find()) {
                String expressionsInBrackets = matcher.group();
                String expr = expressionsInBrackets.substring(1, expressionsInBrackets.length() - 1);
                String resultExpressionsInBrackets = String.valueOf(parser.calc(expr));
                int start = matcher.start();
                int end = matcher.end();
                String result = str.substring(0, start) + resultExpressionsInBrackets + str.substring(end);
                return expressionSimplification(result);
            }
            return str;
        }
    }

    private Var calcOneOperation(String strOne, String strOperation, String strTwo) throws CalcException {
        Var two = Var.createVar(strTwo);
        if (strOperation.equals("=")) {
            Var.saveVar(strOne, two);
            return two;
        }
        Var one = Var.createVar(strOne);
        if (one == null || two == null) {
            throw new CalcException("нет переменной");
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
        throw new CalcException("Невозможно определить операцию");
    }

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

    Var calc(String expression) throws CalcException {
        if (expression.trim().equals("printvar")) {
            Var.printVar();
            return null;
        }
        if (expression.trim().equals("sortvar")) {
            Var.sortVar();
            return null;
        }
        checkingTheCorrectnessOfTheExpression(expression);
        if (expression.contains("(") || expression.contains(")")) {
            expression = expressionSimplification(expression);
        }
        String[] tmp = expression.split(Patterns.OPERATION);
        List<String> operands = new ArrayList<>(Arrays.asList(tmp));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
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

    private static boolean checkingTheCorrectnessOfTheExpression(String expression) {
        Pattern patternError = Pattern.compile("(\\(|\\[|\\{)(\\)|\\+|\\/|\\*|\\]|\\})");
        Matcher matcherError = patternError.matcher(expression);
        if (matcherError.find()) {
            System.out.println("проверьте корректность выражения в скобках ");
            return false;
        }
        Pattern patternZn = Pattern.compile("(,|\\*|\\+|\\/|\\-)(,|\\*|\\+|\\/)");
        Matcher matcherZn = patternZn.matcher(expression);
        if (matcherZn.find()) {
            System.out.println("проверьте корректность расстановки знаков * + , / -");
            return false;
        }
        Pattern patternZ = Pattern.compile("(\\(|\\[|\\{)(,|\\+|\\*|\\/)");
        Matcher matcherZ = patternZ.matcher(expression);
        if (matcherZ.find()) {
            System.out.println("после открытия скобки символы * + , / не допускаются");
            return false;
        }
        Pattern patternBracket = Pattern.compile("[\\(\\[\\{\\)\\]\\}]");
        List<String> arrayBracket = new ArrayList<>();
        Matcher match = patternBracket.matcher(expression);
        while (match.find()) {
            String bracket = match.group();
            if (arrayBracket.size() == 0) {
                arrayBracket.add(bracket);
            } else if (bracket.equals("(") || bracket.equals("[") || bracket.equals("{")) {
                arrayBracket.add(bracket);
            } else if (bracket.equals(")")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("(")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else {
                    System.out.println("некорректное закрытие скобки  " + arrayBracket.get(arrayBracket.size() - 1));
                    return false;
                }
            } else if (bracket.equals("]")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("[")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else {
                    System.out.println("некорректное закрытие скобки  " + arrayBracket.get(arrayBracket.size() - 1));
                    return false;
                }
            } else if (bracket.equals("}")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("{")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else {
                    System.out.println("некорректное закрытие скобки  " + arrayBracket.get(arrayBracket.size() - 1));
                    return false;
                }
            }
        }
        if (arrayBracket.isEmpty()) {
            return true;
        } else {
            System.out.println("в выражении присутствуют лишнии скобки");
        }
        return false;
    }
}
