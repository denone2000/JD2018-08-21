package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Vector extends AbstractVar{

    private double[] value;

    public Vector(String strVector) {
        //{1,2,3,4,5}
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(",\\s*");
        value=new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i]=Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result=new StringBuilder("{");
        String delimiter="";
        for (double currentValue : value) {
            result.append(delimiter).append(currentValue);
            delimiter=", ";
        }
        result.append("}");
        return result.toString();
    }
}
