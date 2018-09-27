package by.it.kisielev.jd01_07;

 class Scalar extends AbstractVar {
     private double value;

     Scalar(double value) {
         this.value = value;
     }

     Scalar (Scalar otherScalar){ value=otherScalar.value; }

     public  Scalar(String strValue){ value=Double.parseDouble(strValue); }

     @Override
     public String toString() {
         return Double.toString(value);
     }
 }