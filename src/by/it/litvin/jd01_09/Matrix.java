package by.it.litvin.jd01_09;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                result.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            delimiter = "}, {";
        }
        result.append("}}");
        return result.toString();
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    public Matrix(String strMatrix) {

        strMatrix = strMatrix.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strMatrix.split(",\\s*");
        value = new double[2][2];
        int m = 0;
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length; j++) {
                value[i][j] = Double.parseDouble(strArray[m++]);


            }
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] / scalar;
                }
            }
            return new Matrix(res);

        } else
            return super.div(other);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            //double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();

                }
            }
            return new Matrix(res);

        } else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).getValue()[i][j];

                }

            }
            return new Matrix(res);
        } else {

            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            //double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();

                }
            }
            return new Matrix(res);

        } else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).getValue()[i][j];

                }

            }
            return new Matrix(res);
        } else {

            return super.sub(other);
        }
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            //double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j]*((Scalar) other).getValue();

                }
            }
            return new Matrix(res);

        } else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            /*for (int i = 0; i < res.length; i++) {
               for (int j = 0; j < res[i].length; j++) {
                   res[i][j] = res[i][j] * ((Matrix) other).getValue()[i][j];
               }}*/

                double [][]z=new double[res.length][res[0].length] ;
            for (int i = 0; i <res.length ; i++) {
                for (int j = 0; j <res[i].length ; j++) {
                    for (int k = 0; k <res.length ; k++) {
                        z[i][j]+=res[i][k]*((Matrix) other).getValue()[k][j];

                    }


                }

            }
            return new Matrix(z);
        }
     else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] *((Vector) other).getValue()[j];
                }
            }
            double[]z=new double[res.length];
            for (int i = 0; i <res.length ; i++) {
                for (int j = 0; j <res[i].length ; j++) {
                    z[i]+=res[i][j];

                }

            }
            
            return new Vector(z);
        }
     else {

        return super.mul(other);
    }}}


