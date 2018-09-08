package by.it.kisielev.jd01_07;

 class Scalar extends AbstractVar {
    public double value;

    Scalar(double value){
        this.value=value;
    }

    Scalar(Scalar otherScalar){
        this.value=otherScalar.value;
    }

    public Scalar(String strValue){
        value=Double.parseDouble(strValue);
    }

     @Override
     public String toString() {
         return Double.toString(this.value);
     }
 }
