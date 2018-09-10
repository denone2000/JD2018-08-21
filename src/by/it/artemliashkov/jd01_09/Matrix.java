package by.it.artemliashkov.jd01_09;

import java.util.Arrays;

 class Matrix extends Var {
    private double[][] value;
    public Matrix(double[][] value)
    {
        this.value=new double[value.length][value.length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j <this.value.length ; j++) {
                this.value[i][j]=value[i][j];
            }

        }
    }

    public Matrix(Matrix OtherMatrix)
    {
        this.value=new double[OtherMatrix.value.length][OtherMatrix.value.length];
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j <this.value.length ; j++) {
                this.value[i][j]=OtherMatrix.value[i][j];
            }

        }
    }

    Matrix(String strMatrix) {
        String[] arrayString = strMatrix.split("},");
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayString[i].replace("{", "").replace("}", "");
        }
        String[] numberElementInRow = arrayString[0].split(",");
        value = new double[arrayString.length][numberElementInRow.length];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayMatrix = arrayString[i].split(",");
            for (int j = 0; j < arrayMatrix.length; j++) {
                value[i][j] = Double.parseDouble(arrayMatrix[j]);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiterI = "{";
        for (int i = 0; i < value.length; i++) {
            sb.append(delimiterI);
            String delimiterJ = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimiterJ).append(value[i][j]);
                delimiterJ = ", ";
            }
            delimiterI = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] + ((Vector) other).getValue()[i];
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
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else {
            return super.add(other);
        }
    }

    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < 1; j++) {
                    res[i][j] = res[i][j] - ((Vector) other).getValue()[i];
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
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        } else {
            return super.sub(other);
        }
    }

    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            double[] result = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    result[i] = result[i] + res[i][j];
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] result = new double[res.length][res[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    double sum = 0;
                    for (int k = 0; k < res.length; k++) {
                        sum = sum + res[i][k] * ((Matrix) other).value[k][j];
                    }
                    result[i][j] = sum;
                }
            }
            return new Matrix(result);
        } else {
            return super.mul(other);
        }
    }



}
