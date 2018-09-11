package by.it.voinilo.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;


    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] arr = strVector.split(",\\s*");
        value = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            value[i] = Double.parseDouble(arr[i]);
        }
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
        } else
            return super.add(other);
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
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double []res= Arrays.copyOf(value,value.length);
            double sum=0;
            for (int i = 0; i <value.length ; i++) {
                res[i]  =res[i] * ((Vector) other).value[i];
                sum=sum+res[i];
            }
            return new Scalar(sum);

        }
        return super.mul(other);
    }

        @Override
        public Var div (Var other){
            if (other instanceof Scalar) {
                double[] res = Arrays.copyOf(value, value.length);
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] / ((Scalar) other).getValue();
                }
                return new Vector(res);
            }
            else if (other instanceof Vector){
                System.out.println("error");

            }
            return super.div(other);
        }


        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder("{");
            String del = "";
            for (double elem : value) {
                sb.append(del).append(elem);
                del = ", ";
            }
            sb.append("}");
            return sb.toString();
        }
    }
