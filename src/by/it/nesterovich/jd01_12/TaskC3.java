package by.it.nesterovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {
        String expressionTrue = "(3+2)*(45-23)/5+[3+4]";
        String expressionFalse = "(3+2)*5+[(3+4])";

        System.out.println("expression: " + expressionTrue + "   correctness: " + checkingTheCorrectnessOfTheExpression(expressionTrue));
        System.out.println("expression: " + expressionFalse + "   correctness: " + checkingTheCorrectnessOfTheExpression(expressionFalse));
    }

    private static boolean checkingTheCorrectnessOfTheExpression(String expression) {
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
                } else return false;
            } else if (bracket.equals("]")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("[")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else return false;
            } else if (bracket.equals("}")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("{")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else return false;
            }
        }
        return arrayBracket.isEmpty();
    }
}
