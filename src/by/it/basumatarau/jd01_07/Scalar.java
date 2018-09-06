package by.it.basumatarau.jd01_07;

public class Scalar extends AbstractVar {
    private double value;
    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalarObj){
        value = scalarObj.value;
    }
    public Scalar(String strVal){
        value = Double.parseDouble(strVal);
    }
    @Override
    public String toString() {
        return Double.toString(this.value);
    }

}
