package by.it.litvin.calc;

class Scalar extends Var {
    private Logger logger = Logger.getInstance();

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar otherScalar = (Scalar) other;
            double sum = this.value + otherScalar.value;
            return new Scalar(sum);
        } else
            return other.add(this);

    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double sub = this.value - ((Scalar) other).value;
            return new Scalar(sub);
        } else {
            Var minus = new Scalar(-1);
            return minus.mul(other).add(this);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double mul = this.value * ((Scalar) other).value;
            return new Scalar(mul);
        } else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).value == 0)
                System.out.println("Деление на ноль");
            logger.log("Div on zero");
            double div = this.value / ((Scalar) other).value;
            return new Scalar(div);
        } else
            return super.div(this);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
