package by.it.korolchuk.jd02_06;

public class Scalar extends Var {
    CalcLogger logger = CalcLogger.getInstance();
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

    public Scalar(String strValue) {
        value = Double.parseDouble(strValue);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double result = this.value + otherScalar.value;
            return new Scalar(result);
        } else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        } else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0) {
                Res res = Res.INSTANCE;
                logger.log(res.get(by.it.korolchuk.jd02_05.Calc_jd02_05.Str.MSG_DIV_IMPOSSIBLE));
                System.out.println(res.get(by.it.korolchuk.jd02_05.Calc_jd02_05.Str.MSG_DIV_IMPOSSIBLE));
            }
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        } else
            return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
