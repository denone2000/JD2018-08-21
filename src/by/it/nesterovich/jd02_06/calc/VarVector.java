package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;
import java.util.Arrays;

class VarVector extends Var {

    private double[] value;

    VarVector(double[] vector) {
        value = Arrays.copyOf(vector, vector.length);
    }

    VarVector(VarVector vector) {
        this.value = vector.value;
    }

    VarVector(String strVector) {
        strVector = strVector.replace('{', ' ').replace('}', ' ').trim();
        String[] strArray = strVector.split(","); //,\\s?
        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    public double[] getValue() {
        return this.value;
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        if (other instanceof VarScalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((VarScalar) other).getValue();
            }
            return new VarVector(res);
        } else if (other instanceof VarVector) {
            if (((VarVector) other).value.length != this.value.length) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.VECTOR_ADD_VECTOR),TitleType.ERROR);
                throw new CalcException(Res.INSTANCE.get(StrConst.VECTOR_ADD_VECTOR));
            }
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((VarVector) other).value[i];
            }
            return new VarVector(res);
        } else {
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if (other instanceof VarScalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((VarScalar) other).getValue();
            }
            return new VarVector(res);
        } else if (other instanceof VarVector) {
            if (((VarVector) other).value.length != this.value.length) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.VECTOR_SUB_VECTOR),TitleType.ERROR);
                throw new CalcException(Res.INSTANCE.get(StrConst.VECTOR_SUB_VECTOR));
            }
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((VarVector) other).value[i];
            }
            return new VarVector(res);
        } else {
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof VarScalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((VarScalar) other).getValue();
            }
            return new VarVector(res);
        } else if (other instanceof VarVector) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((VarVector) other).value[i];
            }
            double result = 0;
            for (double element : res) {
                result += element;
            }
            return new VarScalar(result);
        } else {
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof VarScalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((VarScalar) other).getValue();
            }
            return new VarVector(res);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element :
                value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
