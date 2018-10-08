package by.it.bindyuk.jd02_06.calcV3;

class Scalar extends Var {
    public double getValue() {
        return value;
    }

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    Scalar(String strScalar) {
        value = Double.parseDouble(strScalar);
    }

    @Override

    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double add = this.value + ((Scalar) other).value;
            return VarSelector.getVar(add);//new Scalar(add);
        } else return other.add(this);
    }

    @Override

    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return VarSelector.getVar(sub);//new Scalar(sub);
        } else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override

    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return VarSelector.getVar(mul);//new Scalar(mul);
        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double div = this.value / ((Scalar) other).value;
            if (((Scalar) other).value == 0) {
                ConsoleRunner.logger.log(ConsoleRunner.res.getKeys(Messages.ERROR_NULL));
                throw new CalcException(ConsoleRunner.res.getKeys(Messages.ERROR_NULL));
            }
            return VarSelector.getVar(div);//new Scalar(div);
        } else

            return super.div(other);
    }

    @Override

    public String toString() {
        return Double.toString(value);
    }
}




























