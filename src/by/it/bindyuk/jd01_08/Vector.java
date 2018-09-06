package by.it.bindyuk.jd01_08;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        value = vector.value;
    }

    public Vector(String strVector){
      strVector = strVector.replace('{', ' ').replace('}',' ').trim();
      String [] strArray = strVector.split(",\\s*");
      value = new double[strArray.length];
        for (int i = 0; i <strArray.length ; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        String delimeter = "";
        for (double currentValue : value) {
            result.append(delimeter).append(currentValue);
            delimeter = ", ";
        }
        result.append("}");
        return result.toString();
    }
}





















//    public Vector(String strVector) {
//        strVector.replace('{', ' ').replace('}', ' ').trim();
//        String[] strArray = strVector.split(",\\s*");
//        value = new double[strArray.length];
//        for (int i = 0; i <strArray.length ; i++) {
//            value[i] = Double.parseDouble(strArray[i]);
//        }
//
//    }
//
//    @Override
//    public  String toString(){
//        StringBuilder result = new StringBuilder("{");
//        String delimeter = "";
//        for (double currentValue : value) {
//            result.append(delimeter).append(currentValue);
//            delimeter = ", ";
//        }
//        result.append("}");
//        return result.toString();
//}
//}
