package by.it.kuzmich.jd01.jd01_07;

class Scalar extends AbstractVar {
    private double value;
    Scalar(){}
    Scalar(double value){
        this.value=value;
    }
    Scalar(Scalar otherScalar){
        value=otherScalar.value;
    }
    Scalar(String strValue){
        value=Double.parseDouble(strValue);
    }
    @Override
    public String toString(){
        return Double.toString(value);
    }
}
