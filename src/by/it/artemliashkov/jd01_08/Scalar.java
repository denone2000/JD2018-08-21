package by.it.artemliashkov.jd01_08;

class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value=value;
    }

    Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }
    Scalar(String strScala) {
        this.value = Double.parseDouble(strScala);
    }

    @Override
    public String toString(){
        return Double.toString(this.value);
    }




}
