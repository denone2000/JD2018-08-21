package by.it.galushka.demo.findBrackets;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Run {
    public static void main(String[] args) {
        String ex = "((4.0-0.15)-20.0)/(7.0-5.0)";
        String str = "(4.0-5.0)";
        double res = findBracket(ex);
//        double v = countBrackets(str);
        System.out.println(res);
    }

    private static double findBracket(String ex) {
        StringBuilder sb = new StringBuilder(ex);
        List<String> brackets = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.SINGLE_BACKETS).matcher(ex);
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
            findBracket(result);
        }
        StringBuilder newSb = new StringBuilder("(").append(sb).append(")");
        String s = newSb.toString();
        double res = countBrackets(s);
        return res;
    }

    private static double countBrackets(String str) {
        Matcher matcher = Pattern.compile(Patterns.SCALAR).matcher(str);
        List<Double> scalars = new ArrayList<>();
        while (matcher.find()) {
            double scalar = Double.parseDouble(matcher.group());
            scalars.add(scalar);
        }
        double res = 0.0;
        if (str.contains("+")) {
            res = scalars.get(0) + scalars.get(1);
        } else if (str.contains("-")) {
            res = scalars.get(0) - scalars.get(1);
        } else if (str.contains("*")) {
            res = scalars.get(0) * scalars.get(1);
        } else if (str.contains("/")) {
            res = scalars.get(0) / scalars.get(1);
        } else {
            System.out.println("ошибка!");
        }
        return res;
    }
}

