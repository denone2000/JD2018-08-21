package by.it.artemliashkov.jd01_08;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] doubles)
    {
        value= Arrays.copyOf(doubles,doubles.length);
    }

    public Vector(Vector otherVector)
    {
        this.value=new double[otherVector.value.length];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i]=otherVector.value[i];

        }
    }


    public  Vector(String strVector)
    {
        strVector=strVector.replace('{',' ').replace('}',' ').trim();
        String[] strArray=strVector.split(",\\s*");
        value=new double[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            value[i]=Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString(){
        StringBuilder result=new StringBuilder("{");
        String delimiter="";
        for (double currectValue : value) {
            result.append(delimiter).append(currectValue);
            delimiter=", ";
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.add(other);
        }
    }
    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        } else {
            return super.sub(other);
        }
    }
    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
            }
            double result=0;
            for (int i = 0; i <res.length ; i++) {
                result =result+ res[i];
            }
            return new Scalar(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
         else {
            return super.div(other);
        }
    }

}

