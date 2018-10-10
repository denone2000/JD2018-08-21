package by.it.kisielev.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;
    private Vector(String strVector){
        //{1,2,3,4,5} вот такое число придет в код
        strVector= strVector.replace('{',' ').replace('}',' ').trim();
        String[] strArray= strVector.split(",\\s*");
        value= new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i]=Double.parseDouble(strArray[i]);
        }
    }
    public  Vector(double[] doubles){value= Arrays.copyOf(doubles, doubles.length);}

    @Override
    public  Var add(Var other){
        if (other instanceof Scalar) {
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar;
            }
            return new Vector(result);
        } else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        } else

            return super.add(other);
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
