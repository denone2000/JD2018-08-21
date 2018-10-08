package by.it.bindyuk.jd02_06.calcV3;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String[] yards = strMatrix.split("},");
        String[] yards2 = new String[yards.length];
        for (int i = 0; i < yards2.length; i++) {
            yards2[i] = yards[i].replace('{', ' ').replace('}', ' ').trim();
        }
        value = new double[yards2.length][yards2[0].split(",").length];
        for (int i = 0; i < yards2.length; i++) {
            String[] arrayOfMatrix = yards2[i].split(",");
            for (int j = 0; j < arrayOfMatrix.length; j++) {
                value[i][j] = Double.parseDouble(arrayOfMatrix[j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] addScalar = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                addScalar[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }

            for (int i = 0; i < addScalar.length; i++) {
                for (int j = 0; j < addScalar[i].length; j++) {
                    addScalar[i][j] = addScalar[i][j] + ((Scalar) other).getValue();
                }
            }
            return VarSelector.getVar(addScalar);//new Matrix(addScalar);

        } else if (other instanceof Matrix) {
            double[][] addMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                addMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    addMatrix[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            if (this.value.length != ((Matrix) other).value.length) {
                ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_MATRIX));
                throw new CalcException(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_MATRIX));
            }
            return VarSelector.getVar(addMatrix);//new Matrix(addMatrix);
        } else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] subScalar = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                subScalar[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }

            for (int i = 0; i < subScalar.length; i++) {
                for (int j = 0; j < subScalar[i].length; j++) {
                    subScalar[i][j] = subScalar[i][j] - ((Scalar) other).getValue();
                }
            }
            return VarSelector.getVar(subScalar);//new Matrix(subScalar);

        } else if (other instanceof Matrix) {
            if (this.value[0].length != ((Matrix) other).value[0].length) {
                ConsoleRunner.logger.log(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_MATRIX));
                throw new CalcException(ConsoleRunner.res.getKeys
                        (Messages.ERROR_LENGHT_MATRIX));
            }
            double[][] subMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                subMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    subMatrix[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }

            return VarSelector.getVar(subMatrix);//new Matrix(subMatrix);
        } else return other.add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Matrix) {
            double[][] matrixOne = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                matrixOne[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[][] matrixTwo = new double[((Matrix) other).value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < ((Matrix) other).value.length; i++) {
                matrixTwo[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value[i].length);
            }
            double[][] mulMatrixOneAndTwo = new double[matrixOne.length][matrixTwo[0].length];

            for (int i = 0; i < mulMatrixOneAndTwo.length; i++) {
                for (int j = 0; j < mulMatrixOneAndTwo[0].length; j++) {
                    for (int k = 0; k < matrixTwo.length; k++) {
                        mulMatrixOneAndTwo[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                    }
                }
            }
            return VarSelector.getVar(mulMatrixOneAndTwo);//new Matrix(mulMatrixOneAndTwo);

        } else if (other instanceof Scalar) {
            double[][] scalarMulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                scalarMulMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < scalarMulMatrix.length; i++) {
                for (int j = 0; j < scalarMulMatrix[i].length; j++) {
                    scalarMulMatrix[i][j] = scalarMulMatrix[i][j] * ((Scalar) other).getValue();
                }
            }
            return VarSelector.getVar(scalarMulMatrix);//new Matrix(scalarMulMatrix);
        } else if (other instanceof Vector) {
            double[][] vectorMulMatrix = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < this.value.length; i++) {
                vectorMulMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[] vectorOther = Arrays.copyOf(((Vector) other).getValue(), ((Vector) other).getValue().length);
            double[] resultVector = new double[vectorOther.length];
            for (int i = 0; i < resultVector.length; i++) {
                for (int j = 0; j < resultVector.length; j++) {
                    resultVector[i] += vectorMulMatrix[i][j] * vectorOther[j];
                }
            }
            return VarSelector.getVar(resultVector);//new Vector(resultVector);
        } else return other.mul(this);
    }


    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimeter1 = "{";
        for (int i = 0; i < value.length; i++) {
            result.append(delimeter1);
            String delemeter2 = "";
            for (int j = 0; j < value[i].length; j++) {
                result.append(delemeter2).append(value[i][j]);
                delemeter2 = ", ";
            }
            delimeter1 = "}, {";
        }
        result.append("}}");
        return result.toString();
    }
}

