package by.it.kuzmich.jd_01_07;

 class Scalar extends AbstractVar {
    private double value;

    Scalar(double value){
        this.value = value;
    }
     Scalar(Scalar otherScalar){
         this.value = otherScalar.value;
     }




     @Override
     public String toString() {
         return Double.toString(this.value);
     }
 }
