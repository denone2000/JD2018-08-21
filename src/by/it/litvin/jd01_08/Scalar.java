package by.it.litvin.jd01_08;

class Scalar extends Var {
    private double value;

    Scalar(double value) {
       this.value=value;
    }

    Scalar(Scalar otherScalar){

        value = otherScalar.value;
    }

    public Scalar(String strValue) {

        value=Double.parseDouble(strValue);
    }

    @Override
    public String toString()
    {
        return Double.toString(value);
    }
}
