package by.it.nesterovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение");
        String expression = scanner.nextLine();
        System.out.println("корректность введения выражения: " + checkingTheCorrectnessOfTheExpression(expression));
    }

    private static boolean checkingTheCorrectnessOfTheExpression(String expression) {
        Pattern patternError = Pattern.compile("(\\(|\\[|\\{)(\\)|\\+|\\/|\\*|\\]|\\})");
        Matcher matcherError = patternError.matcher(expression);
        if (matcherError.find()) {
            System.out.println("проверьте корректность выражения в скобках");
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
                    System.out.println("некорректное закрытие скобки " + arrayBracket.get(arrayBracket.size() - 1));
                    return false;
                }
            } else if (bracket.equals("]")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("[")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else {
                    System.out.println("некорректное закрытие скобки " + arrayBracket.get(arrayBracket.size() - 1));
                    return false;
                }
            } else if (bracket.equals("}")) {
                if (arrayBracket.get(arrayBracket.size() - 1).equals("{")) {
                    arrayBracket.remove(arrayBracket.size() - 1);
                } else {
                    System.out.println("некорректное закрытие скобки " + arrayBracket.get(arrayBracket.size() - 1));
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
