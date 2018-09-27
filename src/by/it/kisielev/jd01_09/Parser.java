package by.it.kisielev.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

 class Parser {
    Var calc(String expression){
        //2.0*2.0
        String [] operant=expression.split(Patterns.OPERATION);
        Var one=Var.createVar(operant[0]);
        Var two=Var.createVar(operant[1]);
        if (one==null || two==null){
            //TODO Create error
            System.out.println("Переменная не верна");
            return  null; }
        Pattern p=Pattern.compile(Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        if(m.find()){
            String operation=m.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        //TODO Create error
        System.out.println("Операция не распознона");
        return null;
    }
}
