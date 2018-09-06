package by.it.bindyuk.jd01_08;

class Scalar extends Var {

    private double value;

    Scalar(double value){
        this.value = value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    Scalar(Scalar newscalar){
      value = newscalar.value;
    }

    Scalar(String strScalar){
        value = Double.parseDouble(strScalar);
    }
}




























