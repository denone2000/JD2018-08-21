package by.it.ausiyevich.JD01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(String strVector) {
        strVector = strVector.replace("{", "").replace("}", "");
        String[] strArray = strVector.split("(,\\s*)");
        value = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    public Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = value[i];
        }
    }

    public Vector(Vector anotherVect) {
        this.value = new double[anotherVect.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = anotherVect.value[i];
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            double[] res=Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i]+((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimiter = "";
        for (double currentVal : value) {
            result.append(delimiter).append(currentVal);
            delimiter = ", ";
        }
        result.append("}");
        return result.toString();
    }
}
