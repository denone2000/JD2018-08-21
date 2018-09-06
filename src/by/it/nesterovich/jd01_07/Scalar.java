package by.it.nesterovich.jd01_07;

class Scalar extends AbstractVar {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScala) {
        this.value = Double.parseDouble(strScala);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
