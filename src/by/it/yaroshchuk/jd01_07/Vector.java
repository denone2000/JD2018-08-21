package by.it.yaroshchuk.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends AbstractVar {

    private double[] value;

    Vector(double[] value){
        this.value = value;
    }


    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String str){
        /*String regex = "([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (matcher.find()){
            sb.append(matcher.group());
            i++;
        }*/
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter ="";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
