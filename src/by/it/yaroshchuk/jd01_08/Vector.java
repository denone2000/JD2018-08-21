package by.it.yaroshchuk.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        this.value = Arrays.copyOf(value, value.length);
    }


    Vector(Vector vector){
        this.value = vector.value;
    }

    Vector(String str){
        String regex = "([0-9]*[.])?[0-9]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()){
            sb.append(matcher.group());
            sb.append(" ");
        }
        String strSb = new String(sb);
        String[] strVar = strSb.trim().split(" ");
        value = new double[strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            value[i] = Double.parseDouble(strVar[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar;
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else
            return super.add(this);

    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalar;
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] -= ((Vector) other).value[i];
            }
            return new Vector(result);
        }
        else
            return super.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalar;
            }
            return new Vector(result);
        }
        else if(other instanceof Vector){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] *= ((Vector) other).value[i];
            }
            double res = 0;
            for (double resultElement : result) {
                res += resultElement;
            }
            return new Scalar(res);
        }
        else
            return super.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < result.length; i++) {
                result[i] /= scalar;
            }
            return new Vector(result);
        }
        else
            return super.div(this);
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
