package by.it.galushka.jd02_04;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Brackets {

    static String findBracket(String ex) throws CalcException {
        StringBuilder sb = new StringBuilder(ex);
        List<String> brackets = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.SINGLE_BRACKETS).matcher(ex);
        while (matcher.find()) {
            brackets.add(matcher.group());
        }
        for (int i = 0; i < brackets.size(); i++) {
            String bracketsForCalc = brackets.get(i);
            String calcOneOperation = String.valueOf(countBrackets(bracketsForCalc));
            String sbToString = sb.toString();
            String replace = sbToString.replace(bracketsForCalc, calcOneOperation);
            int length = sb.length();
            sb.delete(0, length);
            sb.append(replace);
        }
        String result = sb.toString();
        if (result.contains("(")) {
            return findBracket(result);
        } else
            return result;
    }

    private static double countBrackets(String str) throws CalcException {
        String[] split = str.split(Patterns.OPERATORS);
        List<String> operands = removeBrackets(split);
        Var var2 = Var.createVar(operands.get(1));
        Var var1 = Var.createVar(operands.get(0));
        double result = 0;
        Var varRes = null;
        if (str.contains("+")) {
            varRes = var1.add(var2);
        } else if (str.contains("-")) {
            varRes = var1.sub(var2);
        } else if (str.contains("*")) {
            varRes = var1.mul(var2);
        } else if (str.contains("/")) {
            varRes = var1.div(var2);
        } else
            System.out.println("Ошибка!");
        result = Double.parseDouble(varRes.toString());
        return result;
    }

    private static List<String> removeBrackets(String[] operands) {
        List<String> list = new ArrayList<>();
        for (String operand : operands) {
            if (operand.contains("(")) {
                String replace = operand.replace("(", "");
                list.add(replace);
            } else if (operand.contains(")")) {
                String replace = operand.replace(")", "");
                list.add(replace);
            }
        }
        return list;
    }
}

