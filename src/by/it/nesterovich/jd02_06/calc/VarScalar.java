package by.it.nesterovich.jd02_06.calc;

import java.io.IOException;

class VarScalar extends Var {

    private double value;

    VarScalar(double value) {
        this.value = value;
    }

    VarScalar(VarScalar scalar) {
        this.value = scalar.value;
    }

    VarScalar(String strScala) {
        this.value = Double.parseDouble(strScala);
    }

    public double getValue() {
        return this.value;
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        if (other instanceof VarScalar) {
            double sum = this.value + ((VarScalar) other).value;
            return new VarScalar(sum);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if (other instanceof VarScalar) {
            double sub = this.value - ((VarScalar) other).value;
            return new VarScalar(sub);
        } else {
            return new VarScalar(-1).mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof VarScalar) {
            double mul = this.value * ((VarScalar) other).value;
            return new VarScalar(mul);
        } else {
            return other.mul(this);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof VarScalar) {
            if (((VarScalar) other).value == 0) {
                Logger.getInstance().writeReport(Res.INSTANCE.get(StrConst.DIVISION_BY_ZERO),TitleType.ERROR);
                throw new CalcException(Res.INSTANCE.get(StrConst.DIVISION_BY_ZERO));
            }
            double div = this.value / ((VarScalar) other).value;
            return new VarScalar(div);
        } else {
            return super.div(other);
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
