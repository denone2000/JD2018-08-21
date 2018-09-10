package by.it.artemliashkov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
     public Var calc(String cmd) {
         String[] strVars=cmd.split(Patterns.OPERATION);
         Var one=Var.createVar(strVars[0]);
         Var two=Var.createVar(strVars[1]);
         Pattern op= Pattern.compile(Patterns.OPERATION);
         Matcher matcher=op.matcher(cmd);
         if(matcher.find())
         {
             String operation= matcher.group();
             switch (operation)
             {
                 case "+": return one.add(two);
                 case "-": return one.sub(two);
                 case "*": return one.mul(two);
                 case "/": return one.div(two);
             }
         }
         System.out.println("Операция не выполнена");
         return null;
     }
 }
