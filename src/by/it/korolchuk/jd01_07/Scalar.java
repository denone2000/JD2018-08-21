package by.it.korolchuk.jd01_07;

class Scalar extends AbstractVar {
    private double value;

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar otherScalar) {
        value = otherScalar.value;
    }

    public Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }
}
