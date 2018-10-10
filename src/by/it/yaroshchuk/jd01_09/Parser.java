package by.it.yaroshchuk.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
     public Var calc(String cmd){
         String [] strVars = cmd.split(Patterns.OPERATION);
         Var one = Var.createVar(strVars[0]);
         Var two = Var.createVar(strVars[1]);
         if (one == null || two == null){
             System.out.println("Переменная не распознана");
             return null;
         }
         Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
         Matcher matcher = patternOperation.matcher(cmd);
         if(matcher.find()){
             String operation = matcher.group();
             switch (operation){
                 case "+": return one.add(two);
                 case "-": return one.sub(two);
                 case "*": return one.mul(two);
                 case "/": return one.div(two);
             }
         }
         //TODO craet err
         System.out.println("операция не распознана");
         return null;
     }
}
